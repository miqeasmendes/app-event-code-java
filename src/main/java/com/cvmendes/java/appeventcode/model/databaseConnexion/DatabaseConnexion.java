package com.cvmendes.java.appeventcode.model.databaseConnexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnexion {

    private static Connection connection;

    public static Connection getConnection() {

        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connect();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("com.mysql.cj.jdbc.Driver est indisponible");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erreur à la connexion");
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion à la base clôturée avec succès");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erreur à la clôture de la connexion");
            }
        }
    }

    private static void connect() throws SQLException {
        String user = "root";
        String password = "cefim";
        String timezone = "UTC";
        String url = "jdbc:mysql://localhost:3307/eventcode?serverTimezone=" + timezone;
        connection = DriverManager.getConnection(url, user, password);
    }
}
