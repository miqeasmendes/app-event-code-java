package com.cvmendes.java.appeventcode.interfaces;

import com.cvmendes.java.appeventcode.model.entities.Evenement;

import java.util.List;

public interface EvenementDAO {

    Evenement findById(Integer id);
    List<Evenement> findAll();

}
