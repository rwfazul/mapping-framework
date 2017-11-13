/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongodb;

import model.conversores.Conversor;
import org.bson.Document;

/**
 *
 * @author rhau
 */
public class PessoaConversorMongoTeste extends Conversor<PessoaMongoTeste> {

    @Override
    public Document toDocument(PessoaMongoTeste p) {
        Document doc = new Document("nome", p.getNome())
                        .append("cpf", p.getCPF());
        return doc;
    }

    @Override
    public PessoaMongoTeste toModel(Document doc) {
        PessoaMongoTeste p = new PessoaMongoTeste();
        p.setId(doc.get("_id").toString());
        p.setNome((String) doc.get("nome"));
        p.setCPF((Integer) doc.get("cpf"));
        return p;
    }
    
}
