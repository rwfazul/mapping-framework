/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conversores;

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
        Document doc = new Document("titulo", p.getTitulo())
                        .append("assunto", p.getAssunto())
                        .append("descricao", p.getDescricao())
                        .append("data", DateUtils.toString(p.getData(), "yyyy/MM/dd"))
                        .append("inicio", DateUtils.toString(p.getHoraInicio(), "HH:mm"))
                        .append("fim", DateUtils.toString(p.getHoraFim(), "HH:mm"))
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
        p.setData(DateUtils.toDate((String) doc.get("data"), "yyyy/MM/dd"));
        p.setHoraInicio(DateUtils.toDate((String) doc.get("inicio"), "HH:mm"));
        p.setHoraFim(DateUtils.toDate((String) doc.get("fim"), "HH:mm"));
        p.setPalestrante(new PalestranteConversor().toModel(doc));
        p.setSala(new SalaConversor().toModel(doc));
        return p;      
    }
    
}
