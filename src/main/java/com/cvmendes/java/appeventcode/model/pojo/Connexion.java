package com.cvmendes.java.appeventcode.model.pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    /**Permet de se connecter à la base de données afin d'effectuer les requêtes nécessaires.
     *
     */

    public static Connection accesBase() throws SQLException{

        /**Initialisation d'une "connection" de la classe Connection à "NULL"(aucune connexion.
         * Chargement du pilote pour base MYSQL avec protocole JDBC (java).
         * instentiation du compte afin de pouvoir se connecter à la base.
         * levée d'exeption en cas de pilote indisponible, connexion non aboutie et
         * finalement, pouvoir fermer la connexion proprement.
         */

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver trouvé");
            String user = "root";
            String password = "cefim";
            String timezone = "UTC";
            String url = "jdbc:mysql://localhost:3307/eventcode?serverTimezone=" + timezone;
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Votre connexion à la base est réussie !");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver indisponible !");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("Erreur de connexion !");
        } finally {
            if (connection == null) {
                return null;
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.print("La connexion est mal clôturée !");
            }
        }
        return connection;
    }


}
