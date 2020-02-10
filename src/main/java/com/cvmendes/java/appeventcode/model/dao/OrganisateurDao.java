package com.cvmendes.java.appeventcode.model.dao;

import com.cvmendes.java.appeventcode.interfaces.OrganisateurDAO;
import com.cvmendes.java.appeventcode.model.databaseConnexion.DatabaseConnexion;
import com.cvmendes.java.appeventcode.model.entities.Organisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrganisateurDao implements OrganisateurDAO {

    @Override
    public Organisateur orgConnection(String mail, String password) throws SQLException {
        String query = "SELECT * FROM organisateur "
                + "WHERE mail = ? AND password = ?  LIMIT 1";

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
        organisateur.setParrainMail(parrainMail(organisateur.getParrainId()));

        return organisateur;
    }

    public String parrainMail(long id) throws SQLException {
        String query = "SELECT mail FROM organisateur "
                + "WHERE id = ? LIMIT 1";
        Connection connection = DatabaseConnexion.getConnection();

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();

        Organisateur organisateur = new Organisateur();
        if (!rs.next())
            return null;

        organisateur.setMail(rs.getString("mail"));
        return organisateur.getMail();
    }
}
