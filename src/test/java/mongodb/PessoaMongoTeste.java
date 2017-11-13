/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongodb;

import banco.Registro;

/**
 *
 * @author rhau
 */
public class PessoaMongoTeste extends Registro {
 
    private String id;
    private String nome;
    private Integer CPF;

    public PessoaMongoTeste() {
        
    }
    
    public PessoaMongoTeste(String nome) {
        this.nome = nome;
    }
    
    public PessoaMongoTeste(String nome, Integer CPF) {
        this.nome = nome;
        this.CPF = CPF;
    }

    public PessoaMongoTeste(String id, String nome, Integer CPF) {
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCPF() {
        return CPF;
    }

    public void setCPF(Integer CPF) {
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", CPF=" + CPF + '}';
    }

}
