package com.cvmendes.java.appeventcode.view;


import com.cvmendes.java.appeventcode.model.databaseConnexion.DatabaseConnexion;
import com.cvmendes.java.appeventcode.model.entities.Organisateur;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionView extends JFrame {

    private JPanel contentPane;
    private JTextField txtEmail;
    private JPasswordField txtPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ConnectionView frame = new ConnectionView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ConnectionView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Dialog", Font.BOLD, 13));
        txtEmail.setBounds(192, 95, 201, 26);
        contentPane.add(txtEmail);
        txtEmail.setColumns(10);

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Dialog", Font.BOLD, 13));
        txtPassword.setBounds(192, 154, 201, 26);
        contentPane.add(txtPassword);

        JLabel txEmail = new JLabel("Email :");
        txEmail.setFont(new Font("Dialog", Font.BOLD, 16));
        txEmail.setBounds(65, 100, 61, 16);
        contentPane.add(txEmail);

        JLabel txPassword = new JLabel("Mot de passe :");
        txPassword.setFont(new Font("Dialog", Font.BOLD, 16));
        txPassword.setBounds(65, 159, 125, 16);
        contentPane.add(txPassword);

        JLabel txTitre = new JLabel("Connection ");
        txTitre.setFont(new Font("Dialog", Font.BOLD, 16));
        txTitre.setBounds(178, 29, 108, 16);
        contentPane.add(txTitre);

        JButton btnSeConnecter = new JButton("Se connecter");
        btnSeConnecter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try{

                    String mail = txtEmail.getText();
                    String password = txtPassword.getText();
                    Connection connection = DatabaseConnexion.getConnection();

                    String query = "SELECT * FROM organisateur WHERE mail = ? AND password = ? LIMIT 1";
                    PreparedStatement st = connection.prepareStatement(query);

                    st.setString(1, mail);
                    st.setString(2, password);

                    ResultSet rs = st.executeQuery();

                    Organisateur organisateur = new Organisateur();

                    if(rs.next()) {
                        setVisible(false);
                        organisateur.setId(rs.getInt("id"));
                        organisateur.setMail(rs.getString("mail"));
                        organisateur.setTypeCompteId(rs.getInt("type_compte_Id"));
                        organisateur.setParrainId(rs.getInt("parrain_Id"));

                        AccueilView frame = new AccueilView();
                        frame.lblOrg.setText("Id : " + organisateur.getId() + " | Mail du Parrain : " + organisateur.getParrainId() + " | Email : " + organisateur.getMail() + " | Type de compte : "+ organisateur.getTypeCompteId() + " | Dernière connection : " + organisateur.getDateDerniereConnexion());
                        frame.lblOrg.setBounds(25, 72, 750, 16);
                        frame.setVisible(true);

                    }else {
                        JOptionPane.showMessageDialog(null, "Identifiants incorrects: veuillez réessayer", "Erreur de connection", JOptionPane.ERROR_MESSAGE);
                        txtEmail.setText(null);
                        txtPassword.setText(null);
                    }
                }catch (SQLException e1) {
                    System.out.println("Erreur de connection");
                   // e1.printStackTrace();
                }




            }
        });

        btnSeConnecter.setFont(new Font("Dialog", Font.BOLD, 16));
        btnSeConnecter.setBounds(163, 224, 136, 29);
        contentPane.add(btnSeConnecter);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                txtEmail.setText(null);
                txtPassword.setText(null);
            }
        });
        btnReset.setFont(new Font("Dialog", Font.BOLD, 16));
        btnReset.setBounds(25, 224, 117, 29);
        contentPane.add(btnReset);

        JButton btnQuitter = new JButton("Quitter");
        btnQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JFrame loginForm = new JFrame("Quitter");
                if(JOptionPane.showConfirmDialog(loginForm, "Etes vous sûr de vouloir quitter ?", "Connection", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                    System.exit(0);
                }
            }
        });
        btnQuitter.setFont(new Font("Dialog", Font.BOLD, 16));
        btnQuitter.setBounds(311, 224, 117, 29);
        contentPane.add(btnQuitter);

        JSeparator separator = new JSeparator();
        separator.setBounds(25, 200, 403, 12);
        contentPane.add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(25, 59, 403, 16);
        contentPane.add(separator_1);
    }
}