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
import model.Predio;

/**
 *
 * @author rhau
 */
public class PredioDAOMySQL extends RegistrosMySQL<Predio> {
    
    public PredioDAOMySQL() {
        setSqlInsercao("");
        setSqlAlteracao("");
        setSqlExclusao("");
        setSqlBuscaChavePrimaria("");
        setSqlBusca("");
        setSqlBuscaTodos("");
    }

    @Override
    protected void preencherInsercao(PreparedStatement ps, Predio p) throws SQLException {
        ps.setString(1, p.getNome());
    }

    @Override
    protected void preencherAlteracao(PreparedStatement ps, Predio p) throws SQLException {
        ps.setString(1, p.getNome());
        ps.setInt(2, p.getId());
    }

    @Override
    protected void preencherExclusao(PreparedStatement ps, Predio p) throws SQLException {
        ps.setInt(1, p.getId());
    }

    @Override
    protected void preencherBusca(PreparedStatement ps, Predio p) throws SQLException {
        ps.setString(1, p.getNome());
    }

    @Override
    protected Predio preencher(ResultSet rs) throws SQLException {
        Predio p = new Predio();
        p.setId(rs.getInt("id_predio"));
        p.setNome(rs.getString("nome_predio"));
        return p;
    }

    @Override
    protected Collection<Predio> preencherLista(ResultSet rs) throws SQLException {
        Collection<Predio> predios = new ArrayList<>();
        while (rs.next())
            predios.add( preencher(rs) );
        return predios;
    }
    
}
