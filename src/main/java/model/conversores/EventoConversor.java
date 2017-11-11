/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conversores;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import model.Evento;
import model.Palestra;
import org.bson.Document;

/**
 *
 * @author isabella
 */
public class EventoConversor extends Conversor<Evento> {

    @Override
    public Document toDocument(Evento e) {
        Document doc = new Document("nome", e.getNome())
                        .append("descricao", e.getDescricao())
                        .append("endereco", e.getEndereco())
                        .append("dataInicio", e.getDataInicio().toString())
                        .append("dataFim", e.getDataFim().toString())
                        .append("predio", new PredioConversor().toDocument(e.getPredio()));
        Collection<Document> documents = new ArrayList<>();
        for (Palestra p : e.getPalestras()) 
            documents.add(new PalestraConversor().toDocument(p));
        doc.append("palestras", documents);
        return doc;
    }

    @Override
    public Evento toModel(Document doc) { 
        Evento e = new Evento();
        e.setIdString(doc.get("_id").toString());
        e.setNome((String) doc.get("nome"));
        e.setDescricao((String) doc.get("descricao"));
        e.setEndereco((String) doc.get("endereco"));
        e.setDataInicio(LocalDate.parse((String) doc.get("dataInicio")));
        e.setDataFim(LocalDate.parse((String) doc.get("dataFim")));
        e.setPredio(new PredioConversor().toModel(doc));
        for (Document d : (Collection<Document>) doc.get("palestras")) 
            e.getPalestras().add(new PalestraConversor().toModel(d));
        return e;
    }
    
}
