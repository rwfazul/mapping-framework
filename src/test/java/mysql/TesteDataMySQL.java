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
        Palestra p = new Palestra();
        p.setTitulo("Titulo");
        p.setDescricao("descricao");
        p.setAssunto("assunto");
        
        Evento e = new Evento();
        e.setId("1");
        p.setEvento(e);
        
        Palestrante pa = new Palestrante();
        pa.setId(1);
        p.setPalestrante(pa);
        
        Sala s = new Sala();
        s.setId(1);
        p.setSala(s);
        
        
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            Date inicio = format.parse("31-01-2016 20:00:00");
            Date fim = format.parse("31-12-1993 12:30:00");
            p.setInicio(inicio);
            p.setFim(fim);
        } catch (ParseException ex) {
            Logger.getLogger(TesteDataMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PalestraDAOMySQL pdao = new PalestraDAOMySQL();
        pdao.inserir(p);
        System.out.println(pdao.buscarTodos());
    }
    
}
