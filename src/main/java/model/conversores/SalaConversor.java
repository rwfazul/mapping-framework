/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conversores;

import model.Sala;
import org.bson.Document;

/**
 *
 * @author rhau
 */
public class SalaConversor extends Conversor<Sala>{

    @Override
    public Document toDocument(Sala s) {
        Document doc = new Document("nome", s.getNome())
                        .append("capacidade", s.getCapacidade())
                        .append("predio", new PredioConversor().toDocument(s.getPredio()));
        return doc;
    }

    @Override
    public Sala toModel(Document doc) {
        Document salaDoc = (Document) doc.get("sala");
        Sala s = new Sala();
        s.setNome((String) salaDoc.get("nome"));
        s.setCapacidade((Integer) salaDoc.get("capacidade"));
        s.setPredio(new PredioConversor().toModel(salaDoc));
        return s;    
    }
    
}
