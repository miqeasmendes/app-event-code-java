package com.cvmendes.java.appeventcode.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionView extends JFrame {

    private JPanel contentPane;
    public JTextField txtEmail;
    public JPasswordField txtPassword;
    public JButton btnSeConnecter;

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

        btnSeConnecter = new JButton("Se connecter");
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