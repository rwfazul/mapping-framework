/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.Collection;

/**
 *
 * @author isabella
 * @param <T>
 */
public interface RegistroDAO<T extends Registro> {
        
    abstract void inserir(T t);
    
    abstract void alterar(T t);
    
    abstract void excluir(T t);
    
    abstract Collection<T> buscar(T t);
    
    abstract Collection<T> buscarTodos();
    
}
