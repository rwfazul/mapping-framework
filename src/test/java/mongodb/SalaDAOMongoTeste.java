/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongodb;

import banco.nosql.mongodb.RegistrosMongo;
import java.util.ArrayList;
import java.util.Collection;
import model.Sala;
import model.conversores.SalaConversor;
import org.bson.Document;

/**
 *
 * @author rhau
 */
public class SalaDAOMongoTeste  extends RegistrosMongo<Sala> {

    @Override
    public void inserir(Sala s) {
        Document doc = new SalaConversor().toDocument(s);
        inserirDocumento(doc);
    }
    
    @Override
    public void alterar(Sala s) {
        Document doc = new SalaConversor().toDocument(s);
        String chave = "_id"; 
        String valor = s.getId().toString();
        alterarDocumento(chave, valor, doc);
    }
    
    @Override
    public void excluir(Sala s) {
        excluirDocumento("_id", s.getId().toString());
    }
    
    @Override
    public Collection<Sala> buscar(Sala s) {
        Collection<Document> documentos = buscarDocumento("nome", s.getNome()); 
        
        Collection<Sala> salas = new ArrayList<>();
        for (Document doc : documentos) {
            Sala sala = new SalaConversor().toModel(doc);
            salas.add(sala);
        }
        
        return salas;
    }
    
    @Override
    public Collection<Sala> buscarTodos() { 
        Collection<Sala> salas = new ArrayList<>();

        Collection<Document> documentos = buscarTodosDocumentos();         
        for (Document doc : documentos) {
            Sala s = new SalaConversor().toModel(doc);
            salas.add(s);
        }
        
        return salas;
    }
    
}
