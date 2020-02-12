package com.cvmendes.java.appeventcode.controller;

import com.cvmendes.java.appeventcode.model.entities.Evenement;

import javax.swing.table.AbstractTableModel;
import java.text.ParseException;
import java.util.List;

public class TableModel extends AbstractTableModel {

    private String[] columnNames = {
            "Evénement",
            "Date et heure",
            "Nb billet en panier",
            "Nb billet vendus",
            "Nb max"
    };

    private Boolean[] editable = {
            true,
            true,
            false,
            false,
            false
    };

    Object[][] data;
    
    public TableModel(List<Evenement> evenements ) throws ParseException {

        data = new Object[evenements.size()][columnNames.length];
        for (int i = 0; i < evenements.size(); i++) {
            data[i][0] = evenements.get(i).getNoml();
            data[i][1] = evenements.get(i).getDateEvenement();
            data[i][3] = evenements.get(i).getNbBilletsVendus();
            data[i][4] = evenements.get(i).getNbBilletsMax();
            data[i][2] = evenements.get(i).getNbBilletsPanier();
        }
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return editable[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
}




