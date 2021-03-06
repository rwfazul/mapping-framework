/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.relacional.mysql;

import banco.relacional.mysql.ConexaoMySQL;
import banco.relacional.mysql.RelacionalDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Palestra;
import model.Sala;

/**
 *
 * @author rhau
 */
public class PalestraDAOMySQL extends RelacionalDAO<Palestra> {

    public PalestraDAOMySQL() {
        setSqlInsercao("INSERT INTO palestra (id_palestrante, id_evento, titulo, assunto_area, descricao_palestra, sala, publico_previsto, data_palestra, hora_inicio, hora_fim) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        setSqlAlteracao("UPDATE palestra set id_palestrante = ?, id_evento = ?, titulo = ?, assunto_area = ?, descricao_palestra = ?, sala = ?, publico_previsto = ?, data_palestra = ?, hora_inicio = ?, hora_fim = ? WHERE id_palestra = ?");
        setSqlExclusao("DELETE FROM palestra WHERE id_palestra = ?");
        setSqlBuscaChavePrimaria("SELECT * FROM palestra WHERE id_palestra = ?");
        setSqlBusca("SELECT * FROM palestra WHERE id_evento = ?"); 
        setSqlBuscaTodos("SELECT * FROM palestra");
    }
    
    @Override
    public Integer inserir(Palestra p) {
        Connection c = ConexaoMySQL.getConexao();
        try {           
            // realiza a insercao do palestrante
            PalestranteDAOMySQL pdao = new PalestranteDAOMySQL();
            // recupera id_palestrante
            Integer id_palestrante = pdao.inserir(p.getPalestrante());
            p.getPalestrante().setId(id_palestrante);
            // realiza a insercao da palestra
            PreparedStatement ps = c.prepareStatement(getSqlInsercao());
            preencherInsercao(ps, p);
            ps.execute();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(PalestraDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1; // sucess
    }
    
    @Override
    protected void preencherInsercao(PreparedStatement ps, Palestra p) throws SQLException {
        ps.setInt(1, p.getPalestrante().getId());
        ps.setInt(2, Integer.parseInt(p.getEvento().getId()));
        ps.setString(3, p.getTitulo());
        ps.setString(4, p.getAssunto());
        ps.setString(5, p.getDescricao());
        ps.setString(6, p.getSala().getNome());
        ps.setInt(7, p.getSala().getPublicoPrevisto());
        ps.setDate(8, new java.sql.Date(p.getData().getTime()));
        ps.setTime(9, new java.sql.Time(p.getHoraInicio().getTime()));
        ps.setTime(10, new java.sql.Time(p.getHoraFim().getTime()));
    }

    @Override
    protected void preencherAlteracao(PreparedStatement ps, Palestra p) throws SQLException {
        ps.setInt(1, p.getPalestrante().getId());
        ps.setInt(2, Integer.parseInt(p.getEvento().getId()));
        ps.setString(3, p.getTitulo());
        ps.setString(4, p.getAssunto());
        ps.setString(5, p.getDescricao());
        ps.setString(6, p.getSala().getNome());
        ps.setInt(7, p.getSala().getPublicoPrevisto());
        ps.setDate(8, new java.sql.Date(p.getData().getTime()));
        ps.setTime(9, new java.sql.Time(p.getHoraInicio().getTime()));
        ps.setTime(10, new java.sql.Time(p.getHoraFim().getTime()));
        ps.setInt(11, p.getId());
    }

    @Override
    protected void preencherExclusao(PreparedStatement ps, Palestra p) throws SQLException {
        ps.setInt(1, p.getId());
    }

    @Override
    protected void preencherBusca(PreparedStatement ps, Palestra p) throws SQLException {
        ps.setInt(1, Integer.parseInt(p.getEvento().getId()));
    }

    @Override
    protected Palestra preencher(ResultSet rs) throws SQLException {
        Palestra p = new Palestra();
        p.setId(rs.getInt("id_palestra"));
        Integer id_palestrante = rs.getInt("id_palestrante");
        p.setPalestrante( new PalestranteDAOMySQL().buscar(id_palestrante.toString()) );
        // p.setEvento( new EventoDAOMySQL().buscar(rs.getInt("id_evento")) );
        p.setTitulo(rs.getString("titulo"));
        p.setAssunto(rs.getString("assunto_area"));
        p.setDescricao(rs.getString("descricao_palestra"));
        p.setSala(new Sala(rs.getString("sala"), rs.getInt("publico_previsto"))); 
        p.setData(rs.getDate("data_palestra"));
        p.setHoraInicio(rs.getTime("hora_inicio"));
        p.setHoraFim(rs.getTime("hora_fim"));
        return p;
    }

    @Override
    protected Collection<Palestra> preencherLista(ResultSet rs) throws SQLException {
        Collection<Palestra> palestras = new ArrayList<>();
        while ( rs.next() )
            palestras.add(preencher(rs));
        return palestras;
    }
    
}
