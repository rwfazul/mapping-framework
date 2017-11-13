/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import banco.Registro;
import java.util.Date;

/**
 *
 * @author rhau
 */
public class Palestra extends Registro {

    private Integer id;
    private Palestrante palestrante;
    private Evento evento; // referencia para criar obj mysql
    private Sala sala;
    private String titulo;
    private String assunto;
    private String descricao;
    private Date inicio;
    private Date fim;

    public Palestra() {
        
    }

    public Palestra(Palestrante palestrante, Evento evento, Sala sala, String titulo, String assunto, String descricao, Date inicio, Date fim) {
        this.palestrante = palestrante;
        this.evento = evento;
        this.sala = sala;
        this.titulo = titulo;
        this.assunto = assunto;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Palestra(Integer id, Palestrante palestrante, Evento evento, Sala sala, String titulo, String assunto, String descricao, Date inicio, Date fim) {
        this.id = id;
        this.palestrante = palestrante;
        this.evento = evento;
        this.sala = sala;
        this.titulo = titulo;
        this.assunto = assunto;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
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
     * @return the palestrante
     */
    public Palestrante getPalestrante() {
        return palestrante;
    }

    /**
     * @param palestrante the palestrante to set
     */
    public void setPalestrante(Palestrante palestrante) {
        this.palestrante = palestrante;
    }

    /**
     * @return the evento
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    /**
     * @return the sala
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the assunto
     */
    public String getAssunto() {
        return assunto;
    }

    /**
     * @param assunto the assunto to set
     */
    public void setAssunto(String assunto) {
        this.assunto = assunto;
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
     * @return the inicio
     */
    public Date getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the fim
     */
    public Date getFim() {
        return fim;
    }

    /**
     * @param fim the fim to set
     */
    public void setFim(Date fim) {
        this.fim = fim;
    }

    @Override
    public String toString() {
        return "Palestra{" + "id=" + id + ", palestrante=" + palestrante + ", evento=" + evento + ", sala=" + sala + ", titulo=" + titulo + ", assunto=" + assunto + ", descricao=" + descricao + ", inicio=" + inicio + ", fim=" + fim + '}';
    }    
    
}
