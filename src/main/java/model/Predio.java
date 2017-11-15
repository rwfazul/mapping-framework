/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import banco.Registro;

/**
 *
 * @author rhau
 */
public class Predio extends Registro {
    
    private String nome;

    public Predio() {
        
    }
    
    public Predio(String nome) {
        this.nome = nome;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Predio{" + "nome=" + nome + '}';
    }

}
