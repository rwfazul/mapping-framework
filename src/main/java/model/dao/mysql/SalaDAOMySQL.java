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
import model.Sala;

/**
 *
 * @author rhau
 */
public class SalaDAOMySQL extends RegistrosMySQL<Sala> {

    public SalaDAOMySQL() {
        setSqlInsercao("");
        setSqlAlteracao("");
        setSqlExclusao("");
        setSqlBuscaChavePrimaria("");
        setSqlBusca("");
        setSqlBuscaTodos("");
    }
    
    @Override
    protected void preencherInsercao(PreparedStatement ps, Sala s) throws SQLException {
        ps.setInt(1, s.getPredio().getId());
        ps.setString(2, s.getNome());
        ps.setInt(3, s.getCapacidade());
    }

    @Override
    protected void preencherAlteracao(PreparedStatement ps, Sala s) throws SQLException {
        ps.setInt(1, s.getPredio().getId());
        ps.setString(2, s.getNome());
        ps.setInt(3, s.getCapacidade());
        ps.setInt(4, s.getId());
    }

    @Override
    protected void preencherExclusao(PreparedStatement ps, Sala s) throws SQLException {
        ps.setInt(4, s.getId());
    }

    @Override
    protected void preencherBusca(PreparedStatement ps, Sala s) throws SQLException {
        ps.setString(1, s.getNome());
    }

    @Override
    protected Sala preencher(ResultSet rs) throws SQLException {
        Sala s = new Sala();
        s.setId(rs.getInt("id_sala"));
        s.setPredio( new PredioDAOMySQL().buscar(rs.getInt("id_predio")) );
        s.setNome(rs.getString("nome_sala"));
        s.setCapacidade(rs.getInt("capacidade"));
        return s;
    }

    @Override
    protected Collection<Sala> preencherLista(ResultSet rs) throws SQLException {
        Collection<Sala> salas = new ArrayList<>();
        while (rs.next())
            salas.add( preencher(rs) );
        return salas;
    }
    
}
