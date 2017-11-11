/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.conversores;

import model.Palestrante;
import org.bson.Document;

/**
 *
 * @author rhau
 */
public class PalestranteConversor extends Conversor<Palestrante> {

    @Override
    public Document toDocument(Palestrante p) {
        Document doc = new Document("nome", p.getNome())
                        .append("sexo", p.getSexo())
                        .append("grauAcademico", p.getGrauAcademico())
                        .append("cursoFormacao", p.getCursoFormacao())
                        .append("instituicaoFormacao", p.getInstituicaoFormacao());
        return doc;    
    }

    @Override
    public Palestrante toModel(Document doc) {
        Document palestranteDoc = (Document) doc.get("palestrante");   
        Palestrante p = new Palestrante();
        p.setNome((String) palestranteDoc.get("nome"));
        p.setSexo((palestranteDoc.get("sexo").toString().charAt(0)));
        p.setGrauAcademico((String) palestranteDoc.get("grauAcademico"));
        p.setCursoFormacao((String) palestranteDoc.get("cursoFormacao"));
        p.setInstituicaoFormacao((String) palestranteDoc.get("instituicaoFormacao"));
        return p;        
    }
    
}
