/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.Evento;

/**
 *
 * @author rhau
 */
public class TestaDatas {
    
    public static void main(String[] args) {

        String data = "25-01-2016";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(data, formatter);
        Evento e = new Evento();
        e.setDataInicio(date);
        System.out.println(e.getDataInicio());
        data = e.getDataInicio().format(formatter);
        System.out.println(data);
        
                
        
    }
    
}
