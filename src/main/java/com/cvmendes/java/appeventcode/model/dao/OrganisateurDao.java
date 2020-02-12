package com.cvmendes.java.appeventcode.model.dao;

import com.cvmendes.java.appeventcode.model.entities.Evenement;
import com.cvmendes.java.appeventcode.model.entities.Organisateur;
import com.cvmendes.java.appeventcode.model.handler.OrganisateurHandler;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.*;
import java.text.ParseException;

public class OrganisateurDao {

   /* @Override
    public Organisateur orgConnection(String mail, String password) throws SQLException {
        String query = "SELECT o.*, tc.nom, og.mail as mailParrain  FROM organisateur o INNER JOIN organisateur og ON og.id=o.parrain_id INNER JOIN type_compte tc ON tc.id = o.type_compte_id where o.mail = ? and o.password = ?";


        Connection connection = DatabaseConnexion.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, mail);
        stmt.setString(2, password);

        ResultSet rs = stmt.executeQuery();
        Organisateur organisateur = new Organisateur();
        if (!rs.next())
            return null;

        organisateur.setId(rs.getInt("id"));
        organisateur.setMail(rs.getString("mail"));
        organisateur.setTypeCompteId(rs.getInt("type_compte_Id"));
        organisateur.setParrainId(rs.getInt("parrain_Id"));
        //organisateur.setParrainMail(parrainMail(organisateur.getParrainId()));
        organisateur.setTypeCompte(rs.getString("nom"));
        organisateur.setParrainMail(rs.getString("mail"));

        return organisateur;
    }*/

    public static Organisateur findOne(Connection connection, String mail, String password) throws SQLException {

        OrganisateurHandler organisateurHandler = new OrganisateurHandler(connection);

        QueryRunner runner = new QueryRunner();
        String query = "SELECT org.*, tc.nom, og.mail as mailParrain  "
                     + "FROM organisateur org "
                     + "INNER JOIN organisateur og "
                     + "ON og.id=org.parrain_id "
                     + "INNER JOIN type_compte tc "
                     + "ON tc.id = org.type_compte_id "
                     + "WHERE org.mail = ? AND org.password = ?";

        Organisateur organisateur = runner.query(connection, query, organisateurHandler, mail, password);
        return organisateur;
    }

    public static void persist(Evenement event, Connection connection) throws SQLException, ParseException {

        if(event.getId() == 0){

            ScalarHandler<Integer> scalarHandler = new ScalarHandler<>();
            QueryRunner runner = new QueryRunner();
            String query = "INSERT INTO evenement (nom, date_evenement) VALUES (?, ?)";
            int newId = runner.insert(connection, query, scalarHandler, event.getNoml(), event.getDateEvenement());

            event.setId(newId);

        } else {

            QueryRunner runner = new QueryRunner();
            String query = "UPDATE evenement SET nom = ?, date_evenement = ? WHERE id = ?";
            runner.update(connection, query, event.getNoml(), event.getDateEvenement(), event.getId());
        }
    }
}
