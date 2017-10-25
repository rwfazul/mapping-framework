/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conversores;

import model.Pessoa;
import org.bson.Document;

/**
 *
 * @author rhau
 */
public class PessoaConversor extends Conversor<Pessoa> {

    @Override
    public Document toDocument(Pessoa p) {
        Document doc = new Document("nome", p.getNome())
                        .append("cpf", p.getCPF());
        return doc;
    }

    @Override
    public Pessoa toModel(Document doc) {
        Pessoa p = new Pessoa();
        p.setId(doc.get("_id").toString());
        p.setNome((String) doc.get("nome"));
        p.setCPF((Integer) doc.get("cpf"));
        return p;
    }
    
}
