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
public class Palestrante extends Registro {

    private Integer id;
    private String nome;
    private char sexo;
    private String grauAcademico;
    private String cursoFormacao;		
    private String instituicaoFormacao;	

    public Palestrante() {
        
    }
   
    public Palestrante(Integer id) {
        this.id = id;
    }
    
    public Palestrante(String nome, char sexo, String grauAcademico, String cursoFormacao, String instituicaoFormacao) {
        this.nome = nome;
        this.sexo = sexo;
        this.grauAcademico = grauAcademico;
        this.cursoFormacao = cursoFormacao;
        this.instituicaoFormacao = instituicaoFormacao;
    }
    
    public Palestrante(Integer id, String nome, char sexo, String grauAcademico, String cursoFormacao, String instituicaoFormacao) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.grauAcademico = grauAcademico;
        this.cursoFormacao = cursoFormacao;
        this.instituicaoFormacao = instituicaoFormacao;
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

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the grauAcademico
     */
    public String getGrauAcademico() {
        return grauAcademico;
    }

    /**
     * @param grauAcademico the grauAcademico to set
     */
    public void setGrauAcademico(String grauAcademico) {
        this.grauAcademico = grauAcademico;
    }

    /**
     * @return the cursoFormacao
     */
    public String getCursoFormacao() {
        return cursoFormacao;
    }

    /**
     * @param cursoFormacao the cursoFormacao to set
     */
    public void setCursoFormacao(String cursoFormacao) {
        this.cursoFormacao = cursoFormacao;
    }

    /**
     * @return the instituicaoFormacao
     */
    public String getInstituicaoFormacao() {
        return instituicaoFormacao;
    }

    /**
     * @param instituicaoFormacao the instituicaoFormacao to set
     */
    public void setInstituicaoFormacao(String instituicaoFormacao) {
        this.instituicaoFormacao = instituicaoFormacao;
    }

    @Override
    public String toString() {
        return "Palestrante{" + "id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", grauAcademico=" + grauAcademico + ", cursoFormacao=" + cursoFormacao + ", instituicaoFormacao=" + instituicaoFormacao + '}';
    }
    
}
