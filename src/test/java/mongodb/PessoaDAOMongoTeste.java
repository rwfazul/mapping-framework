/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongodb;

import banco.nosql.mongodb.RegistrosMongo;
import java.util.ArrayList;
import java.util.Collection;
import org.bson.Document;

/**
 *
 * @author rhau
 */
public class PessoaDAOMongoTeste extends RegistrosMongo<PessoaMongoTeste> {
   
    @Override
    public Integer inserir(PessoaMongoTeste p) {
        Document doc = new PessoaConversorMongoTeste().toDocument(p);
        inserirDocumento(doc);
        return 1; // sucess
    }
    
    @Override
    public void alterar(PessoaMongoTeste p) {
        Document doc = new PessoaConversorMongoTeste().toDocument(p);
        String chave = "_id"; 
        String valor = p.getId();
        alterarDocumento("_id", p.getId(), doc);
    }
    
    @Override
    public void excluir(PessoaMongoTeste p) {
        excluirDocumento("_id", p.getId());
    }
    
    @Override
    public Collection<PessoaMongoTeste> buscar(PessoaMongoTeste p) {
        Collection<Document> documentos = buscarDocumento("nome", p.getNome()); 
        
        Collection<PessoaMongoTeste> pessoas = new ArrayList<PessoaMongoTeste>();
        for (Document doc : documentos) {
            PessoaMongoTeste pessoa = new PessoaConversorMongoTeste().toModel(doc);
            pessoas.add(pessoa);
        }
        
        return pessoas;
    }
    
    @Override
    public Collection<PessoaMongoTeste> buscarTodos() { 
        Collection<PessoaMongoTeste> pessoas = new ArrayList<PessoaMongoTeste>();

        Collection<Document> documentos = buscarTodosDocumentos();         
        for (Document doc : documentos) {
            PessoaMongoTeste p = new PessoaConversorMongoTeste().toModel(doc);
            pessoas.add(p);
        }
        
        return pessoas;
    }
    
}
