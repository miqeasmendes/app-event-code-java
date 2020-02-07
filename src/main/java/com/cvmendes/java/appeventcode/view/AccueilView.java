package com.cvmendes.java.appeventcode.view;

import com.cvmendes.java.appeventcode.controller.Controller;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.TableModel;


public class AccueilView extends JFrame {

    private static final long serialVersionUID = 4443303248990993973L;

    public AccueilView() {
        this.setTitle("App Event Code");
        this.setSize( 800,500 );
        this.setLocationRelativeTo( null );
        this.setDefaultCloseOperation( EXIT_ON_CLOSE );

    }

}
