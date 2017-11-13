/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author rhau
 */
public class TesteDatas {
    
    public static void main(String[] args) {
        // LOCALDATE E LOCALDATETIME
        String dataString = "25-01-2016";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date1 = LocalDate.parse(dataString, formatter1);
        System.out.println(date1);
        dataString = date1.format(formatter1);
        System.out.println(dataString); 
        
        dataString = "25-01-2016 22:00";
        formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dateTime1 = LocalDateTime.parse(dataString, formatter1);
        System.out.println(dateTime1);
        dataString = dateTime1.format(formatter1);
        System.out.println(dataString); 
         
        // DATE (Pode ser usado como DATE, DATETIME e TIMESTAMP no MySQL)
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date date2 = formatter2.parse("2012-12-13 14:54"); // mysql datetime format
            System.out.println(formatter2.format(date2));
        } catch (ParseException ex) {
            Logger.getLogger(TesteDatas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SimpleDateFormat formatter3 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try {
            Date date3 = formatter3.parse("12-11-2012 14:54"); // mysql datetime format
            System.out.println(formatter2.format(date3));
        } catch (ParseException ex) {
            Logger.getLogger(TesteDatas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
