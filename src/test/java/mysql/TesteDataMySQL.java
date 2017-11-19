package mysql;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Evento;
import model.Palestra;
import model.Palestrante;
import model.Sala;
import model.dao.mysql.PalestraDAOMySQL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rhau
 */
public class TesteDataMySQL {
    
    public static void main(String[] args) {  
        System.out.println();
        Palestra p = new Palestra();
        p.setTitulo("Titulo");
        p.setDescricao("descricao");
        p.setAssunto("assunto");
        p.setPalestrante(new Palestrante("Paulo", 'M', "Mestrado", "Sistemas de Informação", "UFSM"));
        
        Evento e = new Evento();
        e.setId("1"); // ja deve estar inserido
        p.setEvento(e);
       
        Sala s = new Sala("335", 12);
        p.setSala(s);
        
        SimpleDateFormat formatData = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date data = formatData.parse("12-05-1997");
            p.setData(data);
        } catch (ParseException ex) {
            Logger.getLogger(TesteDataMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        try {
            Date inicio = format.parse("20:00");
            Date fim = format.parse("21:30");
            p.setHoraInicio(inicio);
            p.setHoraFim(fim);
        } catch (ParseException ex) {
            Logger.getLogger(TesteDataMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PalestraDAOMySQL pdao = new PalestraDAOMySQL();
        pdao.inserir(p);
        System.out.println(pdao.buscarTodos());
    }
    
}
