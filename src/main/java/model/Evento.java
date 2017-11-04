/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import banco.Registro;
import java.time.LocalDate;

/**
 *
 * @author isabella
 */
public class Evento extends Registro {
    private String id_evento;
    private String nome;
    private String descricao;
    private LocalDate data_inicio;
    private LocalDate data_fim;

    public Evento(){
        
    }
    public Evento(String nome){
        this.nome = nome;
    }
    
    public Evento(String nome, String descricao, LocalDate data_inicio, LocalDate data_fim) {
        this.nome = nome;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
    }
    
    

    public String getId_evento() {
        return id_evento;
    }

    public void setId_evento(String id_evento) {
        this.id_evento = id_evento;
    }
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDate getData_fim() {
        return data_fim;
    }

    public void setData_fim(LocalDate data_fim) {
        this.data_fim = data_fim;
    }
    
    @Override
    public String toString() {
        return "Evento{" + "id=" + id_evento + ", nome=" + nome + ""
                + ", descricao=" + descricao + ", data_inicio=" + data_inicio + ""
                + ", data_fim=" + data_fim + '}';
    }
    
}
