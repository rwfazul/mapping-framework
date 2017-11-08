/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

    CREATE TABLE `evento` (
      `id_evento` int(11) NOT NULL AUTO_INCREMENT,
      `nome` varchar(50) NOT NULL,
      `descricao` text NOT NULL,
      `data_inicio` date NOT NULL,
      `data_fim` date NOT NULL,
      `endereco` varchar(100) NOT NULL,
      `predio` int(11) NOT NULL,
      `sala` varchar(10) NOT NULL,
      PRIMARY KEY (`id_evento`)
    ) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 

 */
package model;

import banco.Registro;
import java.time.LocalDate;

/**
 *
 * @author isabella
 */
public class Evento extends Registro {
    
    private String id;
    private String nome;
    private String descricao;
    private LocalDate data_inicio;
    private LocalDate data_fim;
    private String endereco;
    private Integer predio;
    private Integer sala;

    public Evento(){
        
    }
        
    public Evento(String nome){
        this.nome = nome;
    }

    public Evento(String nome, String descricao, LocalDate data_inicio, LocalDate data_fim, String endereco, Integer predio, Integer sala) {
        this.nome = nome;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.endereco = endereco;
        this.predio = predio;
        this.sala = sala;
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
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getSala() {
        return sala;
    }

    public void setSala(Integer sala) {
        this.sala = sala;
    }


    public Integer getPredio() {
        return predio;
    }

    public void setPredio(Integer predio) {
        this.predio = predio;
    }
    
    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", nome=" + nome + ""
                + ", descricao=" + descricao + ", data_inicio=" + data_inicio + ""
                + ", data_fim=" + data_fim + ", endereco=" + endereco + ""
                + ", predio=" + predio + ", sala=" + sala + '}';
    }
    
}
