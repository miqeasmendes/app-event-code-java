package com.cvmendes.java.appeventcode.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccueilView extends JFrame {

    private JPanel contentPane;
    //public JTable table;
    public JLabel lblOrg;
    public JScrollPane scrollPane;

    public AccueilView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel txTitre = new JLabel("Event Code System");
        txTitre.setFont(new Font("Dialog", Font.BOLD, 20));
        txTitre.setBounds(320, 19, 202, 29);
        contentPane.add(txTitre);

        JSeparator separator = new JSeparator();
        separator.setBounds(25, 494, 757, 12);
        contentPane.add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(25, 46, 757, 16);
        contentPane.add(separator_1);

        JButton btnSeDeconnecter = new JButton("Se déconnecter");
        btnSeDeconnecter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TO DO se déconnecter
            }
        });
        btnSeDeconnecter.setBounds(610, 528, 159, 29);
        contentPane.add(btnSeDeconnecter);

        lblOrg = new JLabel("org", JLabel.CENTER);
        //lblOrg.setBounds(25, 72, 61, 16);
        contentPane.add(lblOrg);

        scrollPane = new JScrollPane();
        //scrollPane.add(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(25, 115, 750, 350);
        //scrollPane.setBounds(31, 160, 751, 283);
        contentPane.add(scrollPane);






        //table = new JTable();
        //table.setBounds(25, 100, 395, 29);


        //contentPane.add(scrollPane);
        //setVisible(true);
    }
}
