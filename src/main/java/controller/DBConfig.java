/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import banco.RegistroDAO;
import model.dao.mongo.EventoDAOMongo;
import model.dao.mysql.EventoDAOMySQL;

/**
 *
 * @author rhau
 */
public class DBConfig {
    
    private final RegistroDAO registroDAO;
           
    public DBConfig() {
        //this.registroDAO = new EventoDAOMongo();
        this.registroDAO = new EventoDAOMySQL();
    }

    public RegistroDAO getRegistroDAO() {
        return registroDAO;
    }

}
    

