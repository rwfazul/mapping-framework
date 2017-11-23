/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.mysql;

import banco.relacional.mysql.ConexaoMySQL;
import banco.relacional.mysql.RegistrosMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Evento;
import model.Palestra;
import model.Predio;

/**
 *
 * @author isabella
 */
public class EventoDAOMySQL extends RegistrosMySQL<Evento> {

    public EventoDAOMySQL() {
        setSqlInsercao("INSERT INTO evento (nome_evento, descricao_evento, endereco, predio, data_inicio, data_fim) VALUES (?, ?, ?, ?, ?, ?)");
        setSqlAlteracao("UPDATE evento SET nome_evento = ?, descricao_evento = ?, endereco = ?, predio = ?, data_inicio = ?, data_fim = ? WHERE id_evento = ?");
        setSqlExclusao("DELETE FROM evento WHERE id_evento = ?");
        setSqlBuscaChavePrimaria("SELECT * FROM evento WHERE id_evento = ?");
        setSqlBusca("SELECT * FROM evento WHERE nome_evento = ?");
        setSqlBuscaTodos("SELECT * FROM evento");
    }

    @Override
    public Integer inserir(Evento e) { 
        Connection c = ConexaoMySQL.getConexao();
        try {
            PreparedStatement ps = c.prepareStatement(getSqlInsercao(), PreparedStatement.RETURN_GENERATED_KEYS);
            preencherInsercao(ps, e);
            ps.execute();
            // recupera id_evento
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
                e.setId(Integer.toString( rs.getInt(1) )); // pk
            rs.close();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(RegistrosMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }        
        // para cada evento salva as suas palestras
        PalestraDAOMySQL pdao = new PalestraDAOMySQL();
        for (Palestra p : e.getPalestras()) {
            p.setEvento(e);
            pdao.inserir(p);
        }
        return 1; // sucess
    }
    
    @Override
    protected void preencherInsercao(PreparedStatement ps, Evento e) throws SQLException {
        ps.setString(1, e.getNome());
        ps.setString(2, e.getDescricao());
        ps.setString(3, e.getEndereco());
        ps.setString(4, e.getPredio().getNome());
        ps.setDate(5, new java.sql.Date(e.getDataInicio().getTime()));
        ps.setDate(6, new java.sql.Date(e.getDataFim().getTime()));
    }

    @Override
    protected void preencherAlteracao(PreparedStatement ps, Evento e) throws SQLException {
        ps.setString(1, e.getNome());
        ps.setString(2, e.getDescricao());
        ps.setString(3, e.getEndereco());
        ps.setString(4, e.getPredio().getNome());
        ps.setDate(5, new java.sql.Date(e.getDataInicio().getTime()));
        ps.setDate(6, new java.sql.Date(e.getDataFim().getTime()));
        ps.setInt(7, Integer.parseInt(e.getId()));
    }

    @Override
    protected void preencherExclusao(PreparedStatement ps, Evento e) throws SQLException {
        ps.setInt(1, Integer.parseInt(e.getId()));
    }

    @Override
    protected void preencherBusca(PreparedStatement ps, Evento e) throws SQLException {
        ps.setString(1, e.getNome());
    }

    @Override
    protected Evento preencher(ResultSet rs) throws SQLException {
        Evento e = new Evento();
        e.setId(rs.getString("id_evento"));
        e.setPredio(new Predio(rs.getString("predio")));
        e.setNome(rs.getString("nome_evento"));
        e.setDescricao(rs.getString("descricao_evento"));
        e.setEndereco(rs.getString("endereco"));
        e.setDataInicio(rs.getDate("data_inicio"));
        e.setDataFim(rs.getDate("data_fim"));
        
        // busca palestras pelo id_evento
        Palestra p = new Palestra();
        p.setEvento(e); 
        e.setPalestras( new PalestraDAOMySQL().buscar(p) );
        // preencher obj para updates
        for (Palestra palestra: e.getPalestras())
            palestra.setEvento(e);
        
        return e;
    }

    @Override
    protected Collection<Evento> preencherLista(ResultSet rs) throws SQLException {
        Collection<Evento> eventos = new ArrayList<>();
        while (rs.next())
            eventos.add( preencher(rs) );
        return eventos;
    }


}
