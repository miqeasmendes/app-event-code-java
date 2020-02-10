package com.cvmendes.java.appeventcode.model.dao;

import com.cvmendes.java.appeventcode.model.pojo.Connexion;
import com.cvmendes.java.appeventcode.model.pojo.Organisateur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class OrganisateurDao {

    // pour les tests => Scanner scanner = new Scanner(System.in);


    public Map<String, String> mapColumnsToFields() {

        Map<String, String> columnsToFieldsMap = new HashMap<>();

        columnsToFieldsMap.put("type_compte_id", "typeCompteId");
        return columnsToFieldsMap;
    }


    /*
     * Création de la liste pour récupérer les occurences de la base selon requète executée.
     * Sur cette première requète 'requete1", nous irons récupérer la liste des clients
     * Une déclaration "etat" sera instancié pour le suivi de la connexion.
     */

    public Organisateur trouveOrganisateur(String mail, String password) throws SQLException {


        String requete1 = "SELECT id, mail, type_compte_id" +
                "FROM organisateur" +
                "WHERE mail = ? AND password = ?";
        PreparedStatement etat = Connexion.accesBase().prepareStatement(requete1);
        etat.setString(1, mail);
        etat.setString(1, password);

        ResultSet rs = etat.executeQuery(requete1);

        /**un objet "organisateur" de type Organisateur est crée pour accueillir l'occurences de la base de données.
         * Une boucle tant que est executée et vérifie que le contenu de rs n'est pas vide .
         * Le resultat, si il existe, est donné à l'écran (lecture de "organisateur").
         */

        Organisateur organisateur = new Organisateur();

        if (!rs.next()) {
            return null;
        }

        organisateur.setId(rs.getInt("id"));
        organisateur.setMail(rs.getString("mail"));
        organisateur.setTypeCompteId(rs.getInt("typeCompteId"));

        System.out.println(organisateur);

        return organisateur;
    }
}


