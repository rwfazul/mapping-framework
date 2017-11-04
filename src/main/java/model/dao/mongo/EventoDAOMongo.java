/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.mongo;

import banco.nosql.mongodb.RegistrosMongo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import model.Evento;
import model.conversores.EventoConversor;
import org.bson.Document;

/**
 *
 * @author isabella
 */
public class EventoDAOMongo extends RegistrosMongo<Evento> {

    @Override
    public Connection abrir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Evento e) {
        Document doc = new EventoConversor().toDocument(e);
        inserirDocumento(doc);
    }

    @Override
    public void alterar(Evento e){
        Document doc = new EventoConversor().toDocument(e);
        String chave = "_id"; 
        String valor = e.getId_evento();
        alterarDocumento("_id",  e.getId_evento(), doc);
    }

    @Override
    public void excluir(Evento e) {
        excluirDocumento("_id", e.getId_evento());
    }

    @Override
    public Collection<Evento> buscar(Evento e) {
        Collection<Document> documentos = buscarDocumento("nome", e.getNome()); 
        
        Collection<Evento> eventos = new ArrayList<Evento>();
        for (Document doc : documentos) {
            Evento evento = new EventoConversor().toModel(doc);
            eventos.add(evento);
        }
        
        return eventos;
    }

    @Override
    public Collection<Evento> buscarTodos(){
        Collection<Evento> eventos = new ArrayList<Evento>();

        Collection<Document> documentos = buscarTodosDocumentos();         
        for (Document doc : documentos) {
            Evento evento = new EventoConversor().toModel(doc);
            eventos.add(evento);
        }
        
        return eventos;    
    }
    
}