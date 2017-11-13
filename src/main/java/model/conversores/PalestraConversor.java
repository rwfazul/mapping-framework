/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conversores;

import java.text.SimpleDateFormat;
import model.Palestra;
import org.bson.Document;
import util.DateUtils;

/**
 *
 * @author rhau
 */
public class PalestraConversor extends Conversor<Palestra> {

    @Override
    public Document toDocument(Palestra p) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Document doc = new Document("titulo", p.getTitulo())
                        .append("assunto", p.getAssunto())
                        .append("descricao", p.getDescricao())
                        .append("inicio", DateUtils.toString(p.getInicio(), "yyyy-MM-dd HH:mm"))
                        .append("fim", DateUtils.toString(p.getFim(), "yyyy-MM-dd HH:mm"))
                        .append("palestrante", new PalestranteConversor().toDocument(p.getPalestrante()))
                        .append("sala", new SalaConversor().toDocument(p.getSala()));
        return doc;
    }

    @Override
    public Palestra toModel(Document doc) {
        Palestra p = new Palestra();
        p.setTitulo((String) doc.get("titulo"));
        p.setAssunto((String) doc.get("assunto"));
        p.setDescricao((String) doc.get("descricao"));
        p.setInicio(DateUtils.toDate((String) doc.get("inicio"), "yyyy-MM-dd HH:mm"));
        p.setFim(DateUtils.toDate((String) doc.get("fim"), "yyyy-MM-dd HH:mm"));
        p.setPalestrante(new PalestranteConversor().toModel(doc));
        p.setSala(new SalaConversor().toModel(doc));
        return p;      
    }
    
}
