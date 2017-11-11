/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/ 
package model;

import banco.Registro;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author isabella
 */
public class Evento extends Registro {
    
    private Integer id; // provisorio, no fim utilizar apenas o string e fazer parser do id do mysql
    private String idString; 
    private Predio predio; // predio principal onde o evento ocorre
    private String nome;
    private String descricao;
    private String endereco;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Collection<Palestra> palestras = new ArrayList<>(); // referencia para criar obj mongo

    public Evento() {
        
    }

    public Evento(Predio predio, String nome, String descricao, String endereco, LocalDate dataInicio, LocalDate dataFim) {
        this.predio = predio;
        this.nome = nome;
        this.descricao = descricao;
        this.endereco = endereco;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Evento(Integer id, Predio predio, String nome, String descricao, String endereco, LocalDate dataInicio, LocalDate dataFim) {
        this.id = id;
        this.predio = predio;
        this.nome = nome;
        this.descricao = descricao;
        this.endereco = endereco;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
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
     * @return the idString
     */
    public String getIdString() {
        return idString;
    }

    /**
     * @param idString the idString to set
     */
    public void setIdString(String idString) {
        this.idString = idString;
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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the dataInicio
     */
    public LocalDate getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataFim
     */
    public LocalDate getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }    
    
    /**
     * @return the palestras
     */
    public Collection<Palestra> getPalestras() {
        return palestras;
    }

    /**
     * @param palestras the palestras to set
     */
    public void setPalestras(Collection<Palestra> palestras) {
        this.palestras = palestras;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", idString=" + idString + ", predio=" + predio + ", nome=" + nome + ", descricao=" + descricao + ", endereco=" + endereco + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", palestras=" + palestras + '}';
    }
    
}
