/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongodb;

/**
 *
 * @author rhau
 */
public class TestePessoaDAOMongo {
    
    static PessoaDAOMongoTeste pdao = new PessoaDAOMongoTeste();

    public static void main(String[] args) {
        testeBuscarTodos();
        testeInserir(new PessoaMongoTeste("Fulano", 70707070));
        testeBuscarTodos();
        testeDeletar(testeBuscar(new PessoaMongoTeste("Fulano")));
        testeBuscarTodos();
        testeInserir(new PessoaMongoTeste("Ciclano", 808080));
        testeBuscarTodos();
        PessoaMongoTeste busca = testeBuscar(new PessoaMongoTeste("Ciclano"));
        busca.setNome("Beltrano");
        busca.setCPF(909090);
        testeAtualizar(busca);
        testeBuscarTodos();
    }
    
    public static void testeInserir(PessoaMongoTeste p) {
        System.out.println("Inserindo pessoa (" + p.getNome() + ")...");
        pdao.inserir(p);
    }
    
    public static void testeAtualizar(PessoaMongoTeste p) {
        System.out.println("Atualizando pessoa (" + p.getId() + ")...");
        pdao.alterar(p);
    }
    
    public static void testeDeletar(PessoaMongoTeste p) {
        System.out.println("Deletando pessoa (" + p.getNome() + ")...");
        pdao.excluir(p);
    }
    
    public static PessoaMongoTeste testeBuscar(PessoaMongoTeste p) {
        System.out.println("Buscando pessoa (" + p.getNome() + ")...");
        PessoaMongoTeste busca = null;
        for (PessoaMongoTeste pessoa : pdao.buscar(p)) {
            busca = pessoa;
            System.out.println("Encontrou! " + pessoa + "...");
            break;
        }
        return busca;
    }
    
    public static void testeBuscarTodos() {
        System.out.println("Buscando pessoas...");
        for (PessoaMongoTeste p : pdao.buscarTodos())
            System.out.println(p);
    }
    
}
