/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.nosql.mongodb;

import banco.Registro;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import java.util.Collection;
import org.bson.Document;
import org.bson.types.ObjectId;
import banco.InterfaceDAO;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;

/**
 *
 * @author rhau
 * @param <T>
 */
public abstract class DocumentOrientedDAO<T extends Registro> implements InterfaceDAO<T> {
    
    private final MongoCollection<Document> collection;

    public DocumentOrientedDAO() {
        this.collection = ConexaoMongoSingleton.getInstancia().getMongoCollection();
    }

    @Override
    public Integer inserir(T t) {
        Document doc = prepararDocumento(t);
        collection.insertOne(doc);
        return 1; // success
    }

    @Override
    public void alterar(T t) {
        Document doc = prepararDocumento(t);
        String documentId = getDocumentId(t);
        collection.updateOne(eq( "_id", new ObjectId(documentId)), new Document("$set", doc));
    }

    @Override
    public void excluir(T t) {
        String documentId = getDocumentId(t);
        collection.deleteOne( eq("_id",  new ObjectId(documentId)) );       
    }

    @Override
    public Collection<T> buscar(T t) {
        Collection<T> registros = new ArrayList<>();
        String documentId = getDocumentId(t);
        for (Document cur : collection.find( eq("_id", new ObjectId(documentId))) )
            registros.add( prepararRegistro(cur) );
        return registros;
    }

    @Override
    public T buscar(String id) {
        T registro = null;
        for (Document cur : collection.find( eq("_id", new ObjectId(id)) ))
            registro = prepararRegistro(cur);
        return registro;
    }

    @Override
    public Collection<T> buscarTodos() {
        Collection<T> registros = new ArrayList<>();
        for (Document cur : collection.find())
            registros.add( prepararRegistro(cur) );
        return registros;
    }

    protected abstract String getDocumentId(T t);
    
    protected abstract Document prepararDocumento(T t);

    protected abstract T prepararRegistro(Document doc);
    
}
