/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.mysql;

import banco.mysql.RegistrosMySQL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import model.Evento;

/**
 *
 * @author isabella
 */
public class EventoDAOMySQL extends RegistrosMySQL<Evento> {

    public EventoDAOMySQL() {
        setSqlInsercao("INSERT INTO evento (nome, descricao, data_inicio, data_fim) VALUES (?, ?, ?, ?)");
        setSqlAlteracao("UPDATE evento SET nome = ?, descricao = ?, data_inicio = ?, data_fim = ? WHERE id_evento = ?");
        setSqlExclusao("DELETE FROM evento WHERE nome = ?");
        setSqlBusca("SELECT * FROM evento WHERE nome = ?");
        setSqlBuscaTodos("SELECT * FROM evento");
    }

    @Override
    protected void preencherInsercao(PreparedStatement ps, Evento e) throws SQLException {
        ps.setString(1, e.getNome());
        ps.setString(2, e.getDescricao());
        ps.setDate(3, Date.valueOf(e.getData_inicio()));
        ps.setDate(4, Date.valueOf(e.getData_fim()));
    }

    @Override
    protected void preencherAlteracao(PreparedStatement ps, Evento e) throws SQLException {
        ps.setString(1, e.getNome());
        ps.setString(2, e.getDescricao());
        ps.setDate(3, Date.valueOf(e.getData_inicio()));
        ps.setDate(4, Date.valueOf(e.getData_fim()));
        ps.setString(5, e.getId_evento());
    }

    @Override
    protected void preencherExclusao(PreparedStatement ps, Evento e) throws SQLException {
        ps.setString(1, e.getNome());
    }

    @Override
    protected void preencherBusca(PreparedStatement ps, Evento e) throws SQLException {
        ps.setString(1, e.getNome());
    }

    @Override
    protected Evento preencher(ResultSet rs) throws SQLException {
        Evento e = new Evento();
        e.setId_evento(rs.getString("id_evento"));
        e.setNome(rs.getString("nome"));
        e.setDescricao(rs.getString("descricao"));
        e.setData_inicio(rs.getDate("Data_inicio").toLocalDate());
        e.setData_fim(rs.getDate("Data_fim").toLocalDate());
        return e;
    }

    @Override
    protected Collection<Evento> preencherLista(ResultSet rs) throws SQLException {
        Collection<Evento> retorno = new ArrayList<Evento>();
        while (rs.next()) {
            Evento e = new Evento();
            e = preencher(rs);
            retorno.add(e);
        }
        return retorno;
    }

}
