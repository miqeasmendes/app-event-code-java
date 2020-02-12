package com.cvmendes.java.appeventcode.model.handler;

import com.cvmendes.java.appeventcode.model.entities.Evenement;
import com.cvmendes.java.appeventcode.model.entities.Organisateur;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvenementHandler extends BeanListHandler<Evenement> {

    private Connection connection;

    public EvenementHandler(Connection con) {
        super(Evenement.class, new BasicRowProcessor(new BeanProcessor(map())));
        connection = con;
    }

    @Override
    public List<Evenement> handle(ResultSet rs) throws SQLException {
        List<Evenement> evenements = super.handle(rs);

        QueryRunner runner = new QueryRunner();
        //BeanHandler<Organisateur> handler = new BeanHandler<>(Organisateur.class);

        ScalarHandler<Long> scalarHandler = new ScalarHandler<>();
        ScalarHandler<BigDecimal> scalarHandlerBig = new ScalarHandler<>();
        //String query = "SELECT * FROM organisateur WHERE id = ? LIMIT 1";
        String query1 = "SELECT COUNT(*) FROM billet WHERE evenement_id = ? AND panier_client_id IS NOT NULL";
        String query2 = "SELECT COUNT(*) achat_client_id FROM billet WHERE evenement_id = ? AND achat_client_id IS NOT NULL";
        String query3 = "SELECT SUM(nombre_places) FROM categorie_billet WHERE evenement_id = ? ";

        for (Evenement evenement : evenements) {
            //Organisateur organisateur = runner.query(connection, query, handler, evenement.getOrganisateurId());
            long nbBilletPanier = runner.query(connection, query1, scalarHandler, evenement.getId());
            long nbBilletVendus = runner.query(connection, query2, scalarHandler, evenement.getId());
            long nbBilletMax = runner.query(connection, query3, scalarHandlerBig, evenement.getId()).longValueExact();

            //evenement.setOrganisateur(organisateur);
            evenement.setNbBilletsPanier(nbBilletPanier);
            evenement.setNbBilletsVendus(nbBilletVendus);
            evenement.setNbBilletsMax(nbBilletMax);
        }
        return evenements;
    }

    public static Map<String, String> map(){

        Map<String, String> columnsToFieldsMap = new HashMap<>();
        columnsToFieldsMap.put("organisateur_id", "organisateurId");
        columnsToFieldsMap.put("date_evenement", "dateEvenement");
        return columnsToFieldsMap;
    }

}