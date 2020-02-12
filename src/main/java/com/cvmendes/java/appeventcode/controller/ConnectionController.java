package com.cvmendes.java.appeventcode.controller;

import com.cvmendes.java.appeventcode.model.dao.EvenementDao;
import com.cvmendes.java.appeventcode.model.dao.OrganisateurDao;
import com.cvmendes.java.appeventcode.model.databaseConnexion.DatabaseConnexion;
import com.cvmendes.java.appeventcode.model.entities.Organisateur;
import com.cvmendes.java.appeventcode.view.AccueilView;
import com.cvmendes.java.appeventcode.view.ConnectionView;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

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
                                Connection connection = DatabaseConnexion.getConnection();

                                Organisateur organisateur = organisateurDao.findOne(connection, mail, password);

                                frame.lblOrg.setText("Id : " + organisateur.getId() + " | Email : " + organisateur.getMail() + " | Type de compte : " + organisateur.getTypeCompte() + " | Parrain : " + organisateur.getParrainMail());
                                frame.lblOrg.setBounds(25, 72, 750, 16);
                                cv.setVisible(false);
                                frame.setVisible(true);



                                JTable eventTable = new JTable(new TableModel(organisateur.getListEvent()));
                                System.out.println(organisateur.getListEvent());
                                frame.scrollPane.getViewport().add(eventTable);
                                frame.pack();
                                frame.setBounds(100, 100, 800, 600);

                            }else {
                                JOptionPane.showMessageDialog(null, "Identifiants incorrects: veuillez réessayer", "Erreur de connection", JOptionPane.ERROR_MESSAGE);
                                cv.txtEmail.setText(null);
                                cv.txtPassword.setText(null);
                            }
                        }catch (SQLException | ParseException e1) {
                            System.out.println("Erreur de connection");
                            e1.printStackTrace();
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


