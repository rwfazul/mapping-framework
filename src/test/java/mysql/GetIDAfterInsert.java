/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import model.Palestrante;
import model.dao.relacional.mysql.PalestranteDAOMySQL;

/**
 *
 * @author rhau
 */
public class GetIDAfterInsert {
    
    public static void main(String[] args) {
        PalestranteDAOMySQL pdao = new PalestranteDAOMySQL();        
        Palestrante p = new Palestrante("Pedro", 'M', "Doutorado", "Sistemas de Informação", "UFSM");
        System.out.println("id_palestrante = " + pdao.inserir(p));    
    }
   
}
