package com.cvmendes.java.appeventcode.model.dao;

import com.cvmendes.java.appeventcode.model.databaseConnexion.DatabaseConnexion;
import com.cvmendes.java.appeventcode.model.entities.Client;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ClientDAO {

    public static List<Client> findAll() throws SQLException {

        BeanListHandler<Client> handler = new BeanListHandler<>(Client.class);
        QueryRunner runner = new QueryRunner();
        String query = "SELECT * FROM client";
        return runner.query(DatabaseConnexion.getConnection(), query, handler);
    }

}
