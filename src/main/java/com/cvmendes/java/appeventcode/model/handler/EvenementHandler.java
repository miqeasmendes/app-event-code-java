package com.cvmendes.java.appeventcode.model.handler;


import com.cvmendes.java.appeventcode.model.databaseConnexion.DatabaseConnexion;
import com.cvmendes.java.appeventcode.model.entities.Evenement;
import com.cvmendes.java.appeventcode.model.entities.Organisateur;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EvenementHandler extends BeanListHandler<Evenement> {

    private Connection connection = DatabaseConnexion.getConnection();

    public EvenementHandler(Connection con) {
        super(Evenement.class);
        connection = con;
    }

    public List<Evenement> handle(ResultSet rs, String mail) throws SQLException {
        List<Evenement> evenements = super.handle(rs);

        QueryRunner runner = new QueryRunner();
        BeanHandler<Organisateur> handler = new BeanHandler<>(Organisateur.class);
        String query = "SELECT * FROM organisateur WHERE mail = " + mail + " LIMIT 1";

        for (Evenement evenement : evenements) {

            Organisateur organisateur = runner.query(connection, query, handler, evenement.getOrganisateurId());
            evenement.setOrganisateur(organisateur);
        }
        return evenements;
    }

}
