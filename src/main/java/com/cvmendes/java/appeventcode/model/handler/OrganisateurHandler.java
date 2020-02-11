package com.cvmendes.java.appeventcode.model.handler;

import com.cvmendes.java.appeventcode.model.entities.Organisateur;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.util.HashMap;
import java.util.Map;

public class OrganisateurHandler extends BeanHandler<Organisateur> {

    public OrganisateurHandler() {
        super(Organisateur.class, new BasicRowProcessor(new BeanProcessor(map())));
    }

    public static Map<String, String> map(){

        Map<String, String> columnsToFieldsMap = new HashMap<>();
        columnsToFieldsMap.put("type_compte_id", "typeCompteId");
        columnsToFieldsMap.put("parrain_id", "parrainId");
        columnsToFieldsMap.put("nom", "TypeCompte");
        columnsToFieldsMap.put("mailParrain", "parrainMail");
        columnsToFieldsMap.put("date_derniere_conncetion", "dateDerniereConnexion");
        return columnsToFieldsMap;
    }
}
