/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conversores;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import model.Evento;
import org.bson.Document;

/**
 *
 * @author isabella
 */
public class EventoConversor extends Conversor<Evento> {

    @Override
    public Document toDocument(Evento e) {
        Date date1 = Date.from(e.getData_inicio().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date date2 = Date.from(e.getData_fim().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Document doc = new Document("nome", e.getNome())
                        .append("descricao", e.getDescricao())
                        .append("data_inicio", date1)
                        .append("data_fim", date2)
                        .append("endereco", e.getEndereco())
                        .append("predio", e.getPredio())
                        .append("sala", e.getSala());
        
        return doc;
    }

    @Override
    public Evento toModel(Document doc) { 
        Evento e = new Evento();
        
        Date date1 = (Date) doc.get("data_inicio");
        LocalDate data_inicio = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date date2 = (Date) doc.get("data_fim");
        LocalDate data_fim = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
      
        e.setId(doc.get("_id").toString());
        e.setNome((String) doc.get("nome"));
        e.setDescricao((String) doc.get("descricao"));
        e.setData_inicio(data_inicio);
        e.setData_fim(data_fim);
        e.setEndereco((String) doc.get("endereco"));
        e.setPredio((Integer) doc.get("predio"));
        e.setSala((Integer) doc.get("sala"));
        
        return e;
    }
    
}
