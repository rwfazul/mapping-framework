/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongoDB;

import model.Predio;
import model.Sala;

/**
 *
 * @author rhau
 */
public class TesteSalaMongo {
    
    static SalaDAOMongoTeste sdao = new SalaDAOMongoTeste();

    public static void main(String[] args) {
        testeBuscarTodos();
        
        Sala s1 = new Sala();
        s1.setNome("354A");
        s1.setCapacidade(50);
        Predio p1 = new Predio("CT");
        s1.setPredio(p1);
 
        Sala s2 = new Sala();
        s2.setNome("361");
        s2.setCapacidade(30);
        Predio p2 = new Predio("CT - Anexo A");
        s2.setPredio(p2);
        
        testeInserir(s1);
        testeBuscarTodos();
        testeDeletar(testeBuscar(s1));
        testeBuscarTodos();
        testeInserir(s2);
        testeBuscarTodos();
        Sala busca = testeBuscar(s2);
        busca.setNome("1301B");
        busca.setCapacidade(30);
        busca.getPredio().setNome("CT - Anexo C");
        testeAtualizar(busca);
        testeBuscarTodos();
    }
    
    public static void testeInserir(Sala s) {
        System.out.println("Inserindo sala (" + s + ")...");
        sdao.inserir(s);
    }
    
    public static void testeAtualizar(Sala s) {
        System.out.println("Atualizando sala (" + s + ")...");
        sdao.alterar(s);
    }
    
    public static void testeDeletar(Sala s) {
        System.out.println("Deletando sala (" + s + ")...");
        sdao.excluir(s);
    }
    
    public static Sala testeBuscar(Sala s) {
        System.out.println("Buscando sala (" + s + ")...");
        Sala busca = null;
        for (Sala sala : sdao.buscar(s)) {
            busca = sala;
            System.out.println("Encontrou! " + sala + "...");
            break;
        }
        return busca;
    }
    
    public static void testeBuscarTodos() {
        System.out.println("Buscando sala...");
        for (Sala s : sdao.buscarTodos())
            System.out.println(s);
    }
    
}
