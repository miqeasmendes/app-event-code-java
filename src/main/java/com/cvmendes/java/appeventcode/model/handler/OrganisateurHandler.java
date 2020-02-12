package com.cvmendes.java.appeventcode.model.handler;

import com.cvmendes.java.appeventcode.model.entities.Evenement;
import com.cvmendes.java.appeventcode.model.entities.Organisateur;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganisateurHandler extends BeanHandler<Organisateur> {

    public OrganisateurHandler(Connection connection) {
        super(Organisateur.class, new BasicRowProcessor(new BeanProcessor(map())));
        this.connection = connection;

    }

    private Connection connection;

    @Override
    public Organisateur handle(ResultSet rs) throws SQLException {
        Organisateur org = super.handle(rs);
        EvenementHandler evenementHandler = new EvenementHandler(connection);
        QueryRunner runner = new QueryRunner();
        String query = "SELECT * FROM evenement WHERE organisateur_id = ?";
        System.out.println(org.getId());
        List<Evenement> evts = runner.query(connection, query, evenementHandler, org.getId());
        org.setListEvent(evts);
        return org;
    }

    public static Map<String, String> map(){

        Map<String, String> columnsToFieldsMap = new HashMap<>();
        columnsToFieldsMap.put("type_compte_id", "typeCompteId");
        columnsToFieldsMap.put("parrain_id", "parrainId");
        columnsToFieldsMap.put("nom", "TypeCompte");
        columnsToFieldsMap.put("mailParrain", "parrainMail");
        columnsToFieldsMap.put("date_derniere_conncetion", "dateDerniereConnexion");
        return columnsToFieldsMap;
    }
}
