/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoDB;

import java.time.LocalDate;
import model.Evento;
import model.dao.mongo.EventoDAOMongo;
import model.dao.mysql.EventoDAOMySQL;

/**
 *
 * @author isabella
 */
public class TesteEvento {

    static EventoDAOMySQL edao = new EventoDAOMySQL();
    
    public static void main(String[] args) {
        
        /*String banco = "mysq,";
        if("mysql".equals(banco)){
            EventoDAOMySQL edao = new EventoDAOMySQL();
        } else if("mongo".equals(banco)){
            EventoDAOMongo edao = new EventoDAOMongo();
        }*/
            
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.now().plusDays(10);
        
        testeBuscarTodos();
        testeInserir(new Evento("Evento 1", "Descricao evento 1", date1, date2, "endereço 1", 7, 100));
        testeInserir(new Evento("Evento 2", "Descricao evento 2", date1, date2, "endereço 2", 13, 3442));
        testeBuscarTodos();
        testeDeletar(testeBuscar(new Evento("Evento 2")));
        testeBuscarTodos();
        testeInserir(new Evento("Evento 3", "Descricao evento 3", date1, date2, "endereço 3", 42, 213));
        testeBuscarTodos();
        Evento busca = testeBuscar(new Evento("Evento 1"));
        busca.setDescricao("Descricao evento 1 novo");
        testeAtualizar(busca);
        testeBuscarTodos();
    }
    
    public static void testeInserir(Evento e) {
        System.out.println("Inserindo evento (" + e.getNome() + ")...");
        edao.inserir(e);
    }
    
    public static void testeAtualizar(Evento e) {
        System.out.println("Atualizando evento (" + e.getId() + ")...");
        edao.alterar(e);
    }
    
    public static void testeDeletar(Evento e) {
        System.out.println("Deletando evento (" + e.getNome() + ")...");
        edao.excluir(e);
    }
    
    public static Evento testeBuscar(Evento e) {
        System.out.println("Buscando evento (" + e.getNome() + ")...");
        Evento busca = null;
        for (Evento evento : edao.buscar(e)) {
            busca = evento;
            System.out.println("Encontrou! " + evento + "...");
            break;
        }
        return busca;
    }
    
    public static void testeBuscarTodos() {
        System.out.println("Buscando eventos...");
        for (Evento e: edao.buscarTodos())
            System.out.println(e);
    }
    
}
