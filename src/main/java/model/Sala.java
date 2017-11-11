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
    
    private Integer id;
    private Predio predio;
    private String nome;
    private Integer capacidade;

    public Sala() {
        
    }
    
    public Sala(Predio predio, String nome, Integer capacidade) {
        this.predio = predio;
        this.nome = nome;
        this.capacidade = capacidade;
    }
    
    public Sala(Integer id, Predio predio, String nome, Integer capacidade) {
        this.id = id;
        this.predio = predio;
        this.nome = nome;
        this.capacidade = capacidade;
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
     * @return the predio
     */
    public Predio getPredio() {
        return predio;
    }

    /**
     * @param predio the predio to set
     */
    public void setPredio(Predio predio) {
        this.predio = predio;
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
     * @return the capacidade
     */
    public Integer getCapacidade() {
        return capacidade;
    }

    /**
     * @param capacidade the capacidade to set
     */
    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return "Sala{" + "id=" + id + ", predio=" + predio + ", nome=" + nome + ", capacidade=" + capacidade + '}';
    }   
    
}
