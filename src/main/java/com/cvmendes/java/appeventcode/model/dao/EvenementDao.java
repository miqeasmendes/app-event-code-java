package com.cvmendes.java.appeventcode.model.dao;

import com.cvmendes.java.appeventcode.model.entities.Evenement;
import com.cvmendes.java.appeventcode.model.handler.EvenementHandler;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EvenementDao {

    public static List<Evenement> findAll(Connection connection, long id) throws SQLException {

        EvenementHandler evenementHandler = new EvenementHandler(connection);
        QueryRunner runner = new QueryRunner();
        String query = "SELECT * FROM evenement WHERE organisateur_id =  ?";
        List<Evenement> evenements = runner.query(connection, query, evenementHandler, id);

        System.out.println(evenements);
        return evenements;
    }

}
