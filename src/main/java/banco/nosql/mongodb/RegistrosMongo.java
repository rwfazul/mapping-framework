/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.nosql.mongodb;

import banco.Registro;
import banco.RegistroDAO;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.Collection;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author rhau
 * @param <T>
 */
public abstract class RegistrosMongo<T extends Registro> implements RegistroDAO<T> {
    
    private MongoCollection<Document> collection;

    public RegistrosMongo() {
        this.collection = ConexaoMongoSingleton.getInstancia().getMongoCollection();
    }
    
    public void inserirDocumento(Document doc) {
        collection.insertOne(doc);
    }
    
    public void alterarDocumento(String chave, String valor, Document doc) {
        collection.updateOne(eq(chave, new ObjectId(valor)), new Document("$set", doc));
    }
    
    public void excluirDocumento(String chave, String valor) {
        ObjectId id = new ObjectId();
        collection.deleteOne(eq(chave, new ObjectId(valor)));        
    }
    
    public Collection<Document> buscarDocumento(String chave, String valor) {
        Collection<Document> documents = new ArrayList<>();
        for (Document cur : collection.find( eq(chave, new ObjectId(valor) ))) 
            documents.add(cur);
       
        return documents;
    }
    
    public Collection<Document> buscarTodosDocumentos() {
        Collection<Document> documents = new ArrayList<>();
        for (Document cur : collection.find()) 
            documents.add(cur);
        
        return documents;
    }
    
}
