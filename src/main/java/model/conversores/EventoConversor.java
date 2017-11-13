/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conversores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import model.Evento;
import model.Palestra;
import org.bson.Document;
import util.DateUtils;

/**
 *
 * @author isabella
 */
public class EventoConversor extends Conversor<Evento> {

    @Override
    public Document toDocument(Evento e) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Document doc = new Document("nome", e.getNome())
                        .append("descricao", e.getDescricao())
                        .append("endereco", e.getEndereco())
                        .append("dataInicio", DateUtils.toString(e.getDataInicio(), "yyyy-MM-dd"))
                        .append("dataFim", DateUtils.toString(e.getDataFim(), "yyyy-MM-dd"))
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
        e.setId(doc.get("_id").toString());
        e.setNome((String) doc.get("nome"));
        e.setDescricao((String) doc.get("descricao"));
        e.setEndereco((String) doc.get("endereco"));
        e.setDataInicio(DateUtils.toDate((String) doc.get("dataInicio"), "yyyy-MM-dd"));
        e.setDataFim(DateUtils.toDate((String) doc.get("dataFim"), "yyyy-MM-dd"));
        e.setPredio(new PredioConversor().toModel(doc));
        for (Document d : (Collection<Document>) doc.get("palestras")) 
            e.getPalestras().add(new PalestraConversor().toModel(d));
        return e;
    }
    
}
