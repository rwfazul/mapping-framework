/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conversores;

import java.time.LocalDateTime;
import model.Palestra;
import org.bson.Document;

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
                        .append("inicio", p.getInicio().toString())
                        .append("fim", p.getFim().toString())
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
        p.setInicio(LocalDateTime.parse((String) doc.get("inicio")));
        p.setFim(LocalDateTime.parse((String) doc.get("fim")));
        p.setPalestrante(new PalestranteConversor().toModel(doc));
        p.setSala(new SalaConversor().toModel(doc));
        return p;      
    }
    
}
