/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import banco.nosql.mongodb.RegistrosMongo;
import java.util.ArrayList;
import java.util.Collection;
import model.Pessoa;
import model.conversores.PessoaConversor;
import org.bson.Document;

/**
 *
 * @author rhau
 */
public class PessoaDAO extends RegistrosMongo {
    
    public void inserir(Pessoa p) {
        Document doc = new PessoaConversor().toDocument(p);
        inserirDocumento(doc);
    }
    
    public void alterar(Pessoa p) {
        Document doc = new PessoaConversor().toDocument(p);
        String chave = "_id"; 
        String valor = p.getId();
        alterarDocumento("_id", p.getId(), doc);
    }
    
    public void excluir(Pessoa p) {
        excluirDocumento("_id", p.getId());
    }
    
    public Collection<Pessoa> buscar(Pessoa p) {
        Collection<Document> documentos = buscarDocumento("nome", p.getNome()); 
        
        Collection<Pessoa> pessoas = new ArrayList<Pessoa>();
        for (Document doc : documentos) {
            Pessoa pessoa = new PessoaConversor().toModel(doc);
            pessoas.add(pessoa);
        }
        
        return pessoas;
    }
    
    public Collection<Pessoa> buscarTodos() { 
        Collection<Pessoa> pessoas = new ArrayList<Pessoa>();

        Collection<Document> documentos = buscarTodosDocumentos();         
        for (Document doc : documentos) {
            Pessoa p = new PessoaConversor().toModel(doc);
            pessoas.add(p);
        }
        
        return pessoas;
    }
    
}
