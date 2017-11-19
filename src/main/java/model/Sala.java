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
public class Sala extends Registro {
    
    private String nome;
    private Integer publicoPrevisto;

    public Sala() {
        this.publicoPrevisto = 0;
    }
    
    public Sala(String nome) {
        this.nome = nome;
    }
  
    public Sala(String nome, Integer publicoPrevisto) {
        this.nome = nome;
        this.publicoPrevisto = publicoPrevisto;
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

    /**
     * @return the publicoPrevisto
     */
    public Integer getPublicoPrevisto() {
        return publicoPrevisto;
    }

    /**
     * @param publicoPrevisto the publicoPrevisto to set
     */
    public void setPublicoPrevisto(Integer publicoPrevisto) {
        this.publicoPrevisto = publicoPrevisto;
    }

    @Override
    public String toString() {
        return "Sala{" + "nome=" + nome + ", publicoPrevisto=" + publicoPrevisto + '}';
    }
    
}
