package com.cvmendes.java.appeventcode.interfaces;

import com.cvmendes.java.appeventcode.model.entities.Organisateur;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrganisateurDAO {

    //void insert(Organisateur obj);
    //void update(Organisateur obj);
    //void deleteById(Integer id);
    Organisateur findOne(Connection connection, String mail, String password) throws SQLException;
    //String parrainMail(long id) throws SQLException;
    //List<Organisateur> findAll();

}
