package com.cvmendes.java.appeventcode.controller;

import com.cvmendes.java.appeventcode.model.dao.OrganisateurDao;
import com.cvmendes.java.appeventcode.model.databaseConnexion.DatabaseConnexion;
import com.cvmendes.java.appeventcode.model.entities.Evenement;
import com.cvmendes.java.appeventcode.model.entities.Organisateur;
import com.cvmendes.java.appeventcode.view.AccueilView;
import com.cvmendes.java.appeventcode.view.ConnectionView;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.Connection;
import java.util.List;

//public class AccueilController{
//
//        public static void start() {
//            SwingUtilities.invokeLater(() -> {
//                ConnectionView cv = new ConnectionView();
//                AccueilView frame = new AccueilView();
//                Connection connection = DatabaseConnexion.getConnection();
//
//                String mail = cv.txtEmail.getText();
//                String password = cv.txtPassword.getText();
//                JTable table = null;
//                table.setFillsViewportHeight(true);
//
//
//                try {
//                    table = new JTable(new AbstractTableModel() {
//                        //nom, date et heure, nb billets max, nb billets vendus, nb billets en panier
//
//                        private String[] columnNames = {
//                                "Evénement",
//                                "Date et heure",
//                                "Nb billet en panier",
//                                "Nb billet vendus",
//                                "Nb max"
//                        };
//
//                        private Boolean[] editable = {
//                                true,
//                                true,
//                                false,
//                                false,
//                                false
//                        };
//
//                        public Object[][] myTableModel(List<Evenement> evenements ) {
//                            data = new Object[evenements.size()][columnNames.length];
//                            for (int i = 0; i < evenements.size(); i++) {
//                                data[i][0] = evenements.get(i).getNoml();
//                                data[i][1] = evenements.get(i).getDateEvenement();
//                                data[i][2] = evenements.get(i).getNbBilletsMax();
//                                data[i][3] = evenements.get(i).getNbBilletsVendus();
//                                data[i][4] = evenements.get(i).getNbBilletsPanier();
//                            }
//                            return data;
//                        }
//
//                       // Organisateur organisateur = new Organisateur();
//                        // Organisateur organisateur =OrganisateurDao.findOne(connection, mail, password);
//
//                        private Object[][] data;
//
//                        @Override
//                        public int getRowCount() {
//                            return data.length;
//                        }
//
//                        @Override
//                        public int getColumnCount() {
//                            return columnNames.length;
//                        }
//
//                        @Override
//                        public String getColumnName(int column) {
//                            return columnNames[column];
//                        }
//
//                        @Override
//                        public Class<?> getColumnClass(int columnIndex) {
//                            return getValueAt(0, columnIndex).getClass();
//                        }
//
//                        @Override
//                        public boolean isCellEditable(int rowIndex, int columnIndex) {
//                            return editable[columnIndex];
//                        }
//
//                        @Override
//                        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//                            data[rowIndex][columnIndex] = aValue;
//                        }
//
//                        @Override
//                        public Object getValueAt(int rowIndex, int columnIndex) {
//                            return data[rowIndex][columnIndex];
//                        }
//                    });
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                frame.scrollPane = new JScrollPane(table);
//
//                frame.scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//                frame.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//
//            });
//
//        }
//
//}
