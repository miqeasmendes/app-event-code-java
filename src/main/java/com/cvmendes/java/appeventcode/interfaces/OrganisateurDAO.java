package com.cvmendes.java.appeventcode.interfaces;

import com.cvmendes.java.appeventcode.model.entities.Organisateur;

import java.sql.SQLException;
import java.util.List;

public interface OrganisateurDAO {

    //void insert(Organisateur obj);
    //void update(Organisateur obj);
    //void deleteById(Integer id);
    Organisateur orgConnection(String mail, String password) throws SQLException;
    //List<Organisateur> findAll();

}
