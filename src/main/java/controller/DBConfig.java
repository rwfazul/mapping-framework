/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dao.nosql.mongodb.EventoDAOMongo;
import model.dao.relacional.mysql.EventoDAOMySQL;
import banco.InterfaceDAO;

/**
 *
 * @author rhau
 */
public class DBConfig {
    
    // private static final InterfaceDAO registroDAO = new EventoDAOMySQL();
    private static final InterfaceDAO registroDAO = new EventoDAOMongo();
           
    /*
    static {
        registroDAO = new EventoDAOMySQL();
        // registroDAO = new EventoDAOMongo();
    }
    */
    
    public static InterfaceDAO getRegistroDAO() {
        return registroDAO;
    }

}