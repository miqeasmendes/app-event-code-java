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
        organisateur.setPassword("password");

        //List<Organisateur> data = new ArrayList<>();
        //data.add(organisateur);

       // System.out.println(data);

        return organisateur;
    }
}
