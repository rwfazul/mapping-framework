/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.nosql.mongodb;

import banco.nosql.mongodb.DocumentOrientedDAO;
import model.Evento;
import model.conversores.EventoConversor;
import org.bson.Document;

/**
 *
 * @author isabella
 */
public class EventoDAOMongo extends DocumentOrientedDAO<Evento> {

    @Override
    protected String getDocumentId(Evento e) {
        return e.getId();
    }
    
    @Override
    protected Document prepararDocumento(Evento e) {
        return new EventoConversor().toDocument(e);
    }

    @Override
    protected Evento prepararRegistro(Document doc) {
        return new EventoConversor().toModel(doc);
    }

}
