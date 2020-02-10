package com.cvmendes.java.appeventcode.controller;

import com.cvmendes.java.appeventcode.model.dao.OrganisateurDao;
import com.cvmendes.java.appeventcode.model.databaseConnexion.DatabaseConnexion;
import com.cvmendes.java.appeventcode.model.entities.Organisateur;
import com.cvmendes.java.appeventcode.view.AccueilView;
import com.cvmendes.java.appeventcode.view.ConnectionView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class ConnectionController {

    public static void start() {
        SwingUtilities.invokeLater(() -> {

            ConnectionView cv = new ConnectionView();

            cv.btnSeConnecter.addActionListener(e ->
                    // Les opérations SQL n'étant pas instantanées : création d'un Thread
                    (new Thread(() -> {
                        try{

                            String mail = cv.txtEmail.getText();
                            String password = cv.txtPassword.getText();
                            boolean isconnect = true;

                            if(isconnect) {

                                AccueilView frame = new AccueilView();
                                OrganisateurDao organisateurDao = new OrganisateurDao();
                                Organisateur organisateur = organisateurDao.orgConnection(mail, password);
                                frame.lblOrg.setText("Id : " + organisateur.getId() + " | Email : " + organisateur.getMail() + " | Type de compte : " + organisateur.getTypeCompteId() + " | Parrain : " + organisateur.getParrainMail());
                                frame.lblOrg.setBounds(25, 72, 750, 16);
                                cv.setVisible(false);
                                frame.setVisible(true);

                            }else {
                                JOptionPane.showMessageDialog(null, "Identifiants incorrects: veuillez réessayer", "Erreur de connection", JOptionPane.ERROR_MESSAGE);
                                cv.txtEmail.setText(null);
                                cv.txtPassword.setText(null);
                            }
                        }catch (SQLException e1) {
                            System.out.println("Erreur de connection");
                            // e1.printStackTrace();
                        }
                    })).start()
            );
            cv.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    DatabaseConnexion.closeConnection();
                }
            });
            cv.setVisible(true);

        });
    }

}


