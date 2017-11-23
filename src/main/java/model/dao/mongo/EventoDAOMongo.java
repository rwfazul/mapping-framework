/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.mongo;

import banco.nosql.mongodb.RegistrosMongo;
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
    public Integer inserir(Evento e) {
        Document doc = new EventoConversor().toDocument(e);
        inserirDocumento(doc);
        e.setId(doc.getObjectId("_id").toString());
        return 1; // sucess
    }

    @Override
    public void alterar(Evento e){
        Document doc = new EventoConversor().toDocument(e);
        String chave = "_id"; 
        String valor = e.getId();
        alterarDocumento("_id",  e.getId(), doc);
    }

    @Override
    public void excluir(Evento e) {
        excluirDocumento("_id", e.getId());
    }

    @Override
    public Collection<Evento> buscar(Evento e) {
        Collection<Document> documentos = buscarDocumentos("_id", e.getId()); 
        
        Collection<Evento> eventos = new ArrayList<>();
        for (Document doc : documentos) {
            Evento evento = new EventoConversor().toModel(doc);
            eventos.add(evento);
        }
        
        return eventos;
    }

    @Override
    public Evento buscar(String id) {
        return new EventoConversor().toModel(buscarDocumento("_id", id));
    }
    
    @Override
    public Collection<Evento> buscarTodos(){
        Collection<Evento> eventos = new ArrayList<>();

        Collection<Document> documentos = buscarTodosDocumentos();         
        for (Document doc : documentos) {
            Evento evento = new EventoConversor().toModel(doc);
            eventos.add(evento);
        }

        return eventos;    
    }

}
