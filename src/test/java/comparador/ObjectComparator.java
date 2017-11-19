/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparador;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Evento;
import model.Palestra;
import model.Palestrante;
import model.Predio;
import model.Sala;
import mysql.TesteEventoMySQL;

/**
 *
 * @author rhau
 */
public class ObjectComparator {

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        //Palestrante p1 = new Palestrante("Paulo", 'M', "Mestrado", "S.I.", "UFSM");
        //Palestrante p2 = new Palestrante("Paulo", 'M', "Doutorado", "C.C.", "UFSM");
        Evento p1 = cria_evento();
        Evento p2 = cria_evento();
        //p2.setNome("Novo nome");
        //p2.getPredio().setNome("Novo predio");
        //p2.getPalestras().iterator().next().setAssunto("Novo assunto");
        
        Boolean eventoModificado = false;
        Boolean predioModificado = false;
        Collection<Palestra> palestrasModificadas = new ArrayList<>();
        Collection<Palestra> palestrasIncluidas = new ArrayList<>();

        for (Field f : ComparadorObjetos(p1, p2)) {
            switch ( f.getName() ) {
                case "predio":
                    if ( !ComparadorObjetos(p1.getPredio(), p2.getPredio()).isEmpty() )
                        predioModificado = true;
                    break;
                case "palestras":
                        Collection<Palestra> palestrasP1 = p1.getPalestras();
                        Collection<Palestra> palestrasP2 = p2.getPalestras();
                        for (Palestra pB : palestrasP2) {
                           if (pB.getId() == null) { // nova palestra 
                               palestrasIncluidas.add(pB);
                           }
                           else {
                                for (Palestra pA : palestrasP1) {                               
                                    if (pA.getId().equals(pB.getId())) {
                                        boolean palestraModificada = false;
                                        for (Field pfields : ComparadorObjetos(pA, pB)) {
                                            String pfieldsName = pfields.getName();
                                            switch (pfieldsName) {
                                                case "palestrante":
                                                    if ( !ComparadorObjetos(pA.getPalestrante(), pB.getPalestrante()).isEmpty() ) {
                                                        // atualiza palestrante
                                                        System.out.println("Palestrante atualizado");
                                                    }   break;
                                                case "sala":
                                                    if ( !ComparadorObjetos(pA.getSala(), pB.getSala()).isEmpty() ) {
                                                        palestraModificada = true;
                                                    }   break;
                                                default:
                                                    palestraModificada = true;
                                            }   
                                        }
                                        if (palestraModificada) 
                                            palestrasModificadas.add(pB);                          
                                    }
                                }
                            }
                        }
                    break;
                default:
                    eventoModificado = true;
            }
        }
        
    }
    
    private static List<Field> ComparadorObjetos(Object p1, Object p2) throws IllegalArgumentException, IllegalAccessException {
        List<Field> differentFields = new LinkedList<>();
        if (p1 != p2) {
            Class clazz = p1.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field f: fields) {
                boolean accessible = f.isAccessible();
                if (!accessible)
                    f.setAccessible(true);
                Object o1f = f.get(p1);
                Object o2f = f.get(p2);
                if ( !Objects.equals(o1f, o2f) ) {
                    //System.out.println(o1f + " diff " + o2f);
                    differentFields.add(f);
                    //System.out.println(f.getName());
                }
                f.setAccessible(accessible);
            }
        }
        return differentFields;
    }
        
    private static Evento cria_evento() {
        Sala s1 = new Sala();
        s1.setNome("354A");
        s1.setPublicoPrevisto(50);
        Predio p1 = new Predio("CT - Anexo A");
 
        Sala s2 = new Sala();
        s2.setNome("361");
        s2.setPublicoPrevisto(30);
        
        Palestrante pal1 = new Palestrante("Paulo", 'M', "Mestrado", "Sistemas de Informação", "UFSM");
        Palestrante pal2 = new Palestrante("Joana", 'F', "Doutorado", "Ciência da Computação", "PUC");
        
        String data = "02-01-2017 20:00";
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date dateTime = null;
        try {
            dateTime = format.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(TesteEventoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Palestra pa1 = new Palestra();
        pa1.setTitulo("Surpresas do big data");
        pa1.setAssunto("big data");
        pa1.setDescricao("nessa palestra bla bla");
        pa1.setHoraInicio(dateTime);
        pa1.setHoraFim(dateTime);
        pa1.setPalestrante(pal1);
        pa1.setSala(s1);
        pa1.setId(12);
       
        Palestra pa2 = new Palestra();
        pa2.setTitulo("Surpresas do machine learning");
        pa2.setAssunto("machine learning");
        pa2.setDescricao("esta atividade sera bla bla");
        pa2.setHoraInicio(dateTime);
        pa2.setHoraFim(dateTime);
        pa2.setPalestrante(pal2);
        pa2.setSala(s2);
        pa2.setId(13);
        
        data = "25-01-2016";
        format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = format.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(TesteEventoMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        Evento e = new Evento();
        e.setNome("sact");
        e.setDescricao("eng");
        e.setEndereco("ufsm");
        e.setDataFim(date);
        e.setDataInicio(date);
        e.setPredio(p1);
        e.getPalestras().add(pa1);
        e.getPalestras().add(pa2);
        return e;
    }
    
}

