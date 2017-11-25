/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.comparadores;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Evento;
import model.Palestra;
import model.Predio;
import model.dao.mysql.PalestraDAOMySQL;

/**
 *
 * @author rhau
 */
public class EventoMySQLComparador {
    
    public Boolean comparaEventos(Evento antigo, Evento novo) {   
        Boolean eventoModificado = false;
        try {
            for ( Field f : Comparador.compararObjetos(antigo, novo) ) {
                switch ( f.getName() ) {
                    case "predio":
                        eventoModificado = predioModificado(antigo.getPredio(), novo.getPredio());
                        break;
                    case "palestras":
                        palestrasModificadas(antigo.getPalestras(), novo.getPalestras(), antigo);
                        break;
                    default:
                        eventoModificado = true;
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException ex) {
            Logger.getLogger(EventoMySQLComparador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eventoModificado;
    }

    private Boolean predioModificado(Predio predioAntigo, Predio predioNovo) throws IllegalArgumentException, IllegalAccessException {
        return !Comparador.compararObjetos(predioAntigo, predioNovo).isEmpty();
    }

    private void palestrasModificadas(Collection<Palestra> antigas, Collection<Palestra> novas, Evento antigo) {
        // Verifica se existem novas palestras
        for (Palestra nova : novas) {
            if ( nova.getId() == null || nova.getId().equals(0) ) {
                nova.setEvento(antigo);
                new PalestraDAOMySQL().inserir(nova);
            } 
        } 
        // Verifica se alguma palestra antiga foi deletada
        for (Palestra antiga : antigas) {
            Boolean encontrou = false;
            for (Palestra nova: novas) {
                if ( nova.getId() != null ) {
                    if ( nova.getId().equals(antiga.getId()) ) {
                        encontrou = true;
                        break;
                    }
                }
            }
            if ( !encontrou )
                new PalestraDAOMySQL().excluir(antiga);
        }
    }
    
}
