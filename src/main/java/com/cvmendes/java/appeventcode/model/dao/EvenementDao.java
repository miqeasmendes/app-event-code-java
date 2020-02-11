package com.cvmendes.java.appeventcode.model.dao;

import com.cvmendes.java.appeventcode.model.entities.Evenement;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EvenementDao {

    public static List<Evenement> findAll(Connection connection) throws SQLException {

        BeanListHandler<Evenement> beanListHandler = new BeanListHandler<>(Evenement.class);;
        QueryRunner runner = new QueryRunner();
        String query = "SELECT * FROM evenement";
        List<Evenement> evenements = runner.query(connection, query, beanListHandler);

        System.out.println(evenements);
        return evenements;
    }
}
