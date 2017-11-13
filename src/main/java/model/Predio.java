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
    
    private Integer id;
    private String nome;

    public Predio() {
        
    }
    
    public Predio(String nome) {
        this.nome = nome;
    }
    
    public Predio(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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
        return "Predio{" + "id=" + id + ", nome=" + nome + '}';
    }

}
