/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.mysql;

import banco.relacional.mysql.RegistrosMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import model.Palestrante;

/**
 *
 * @author rhau
 */
public class PalestranteDAOMySQL extends RegistrosMySQL<Palestrante> {
    
    public PalestranteDAOMySQL() {
        setSqlInsercao("INSERT INTO palestrante (nome_palestrante, sexo, grau_academico, nome_curso, instituicao) VALUES (?, ?, ?, ?, ?)");
        setSqlAlteracao("UPDATE palestrante SET nome_palestrante = ?, sexo = ?, grau_academico = ?, nome_curso = ?, instituicao = ? WHERE id_palestrante = ?");
        setSqlExclusao("DELETE FROM palestrante");
        setSqlBuscaChavePrimaria("SELECT * FROM palestrante WHERE id_palestrante = ?");
        setSqlBusca("SELECT * FROM palestrante WHERE nome_palestrante = ?");
        setSqlBuscaTodos("SELECT * FROM palestrante");
    }

    @Override
    protected void preencherInsercao(PreparedStatement ps, Palestrante p) throws SQLException {
        ps.setString(1, p.getNome());
        ps.setString(2, String.valueOf(p.getSexo()));
        ps.setString(3, p.getGrauAcademico());
        ps.setString(4, p.getCursoFormacao());
        ps.setString(5, p.getInstituicaoFormacao());
    }

    @Override
    protected void preencherAlteracao(PreparedStatement ps, Palestrante p) throws SQLException {
        ps.setString(1, p.getNome());
        ps.setString(2, String.valueOf(p.getSexo()));
        ps.setString(3, p.getGrauAcademico());
        ps.setString(4, p.getCursoFormacao());
        ps.setString(5, p.getInstituicaoFormacao());    
        ps.setInt(6, p.getId());
    }

    @Override
    protected void preencherExclusao(PreparedStatement ps, Palestrante p) throws SQLException {
        ps.setInt(1, p.getId());
    }

    @Override
    protected void preencherBusca(PreparedStatement ps, Palestrante p) throws SQLException {
        ps.setString(1, p.getNome());
    }

    @Override
    protected Palestrante preencher(ResultSet rs) throws SQLException {
        Palestrante p = new Palestrante();
        p.setId(rs.getInt("id_palestrante"));
        p.setNome(rs.getString("nome_palestrante"));
        p.setSexo(rs.getString("sexo").charAt(0));
        p.setGrauAcademico(rs.getString("grau_academico"));
        p.setCursoFormacao(rs.getString("nome_curso"));
        p.setInstituicaoFormacao(rs.getString("instituicao"));
        return p;
    }

    @Override
    protected Collection<Palestrante> preencherLista(ResultSet rs) throws SQLException {
        Collection<Palestrante> palestrantes = new ArrayList<>();
        while (rs.next())
            palestrantes.add( preencher(rs) );
        return palestrantes;
    }
    
}
