/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MongoDB;

import model.Pessoa;
import model.dao.PessoaDAO;

/**
 *
 * @author rhau
 */
public class TestePessoaDAO {
    
    static PessoaDAO pdao = new PessoaDAO();

    public static void main(String[] args) {
        testeBuscarTodos();
        testeInserir(new Pessoa("Fulano", 70707070));
        testeBuscarTodos();
        testeDeletar(testeBuscar(new Pessoa("Fulano")));
        testeBuscarTodos();
        testeInserir(new Pessoa("Ciclano", 808080));
        testeBuscarTodos();
        Pessoa busca = testeBuscar(new Pessoa("Ciclano"));
        busca.setNome("Beltrano");
        busca.setCPF(909090);
        testeAtualizar(busca);
        testeBuscarTodos();
    }
    
    public static void testeInserir(Pessoa p) {
        System.out.println("Inserindo pessoa (" + p.getNome() + ")...");
        pdao.inserir(p);
    }
    
    public static void testeAtualizar(Pessoa p) {
        System.out.println("Atualizando pessoa (" + p.getId() + ")...");
        pdao.alterar(p);
    }
    
    public static void testeDeletar(Pessoa p) {
        System.out.println("Deletando pessoa (" + p.getNome() + ")...");
        pdao.excluir(p);
    }
    
    public static Pessoa testeBuscar(Pessoa p) {
        System.out.println("Buscando pessoa (" + p.getNome() + ")...");
        Pessoa busca = null;
        for (Pessoa pessoa : pdao.buscar(p)) {
            busca = pessoa;
            System.out.println("Encontrou! " + pessoa + "...");
            break;
        }
        return busca;
    }
    
    public static void testeBuscarTodos() {
        System.out.println("Buscando pessoas...");
        for (Pessoa p : pdao.buscarTodos())
            System.out.println(p);
    }
    
}
