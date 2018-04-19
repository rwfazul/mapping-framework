/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.relacional.mysql;

import banco.Registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import banco.InterfaceDAO;

/**
 *
 * @author isabella
 * @param <T>
 */
public abstract class RelacionalDAO<T extends Registro> implements InterfaceDAO<T> {

    private String sqlInsercao;
    private String sqlAlteracao;
    private String sqlExclusao;
    private String sqlBuscaChavePrimaria;
    private String sqlBusca; // personalizada em cada DAO
    private String sqlBuscaTodos;

    public String getSqlInsercao() {
        return sqlInsercao;
    }

    public void setSqlInsercao(String sqlInsercao) {
        this.sqlInsercao = sqlInsercao;
    }

    public String getSqlAlteracao() {
        return sqlAlteracao;
    }

    public void setSqlAlteracao(String sqlAlteracao) {
        this.sqlAlteracao = sqlAlteracao;
    }

    public String getSqlExclusao() {
        return sqlExclusao;
    }

    public void setSqlExclusao(String sqlExclusao) {
        this.sqlExclusao = sqlExclusao;
    }

    public String getSqlBuscaChavePrimaria() {
        return sqlBuscaChavePrimaria;
    }

    public void setSqlBuscaChavePrimaria(String sqlBuscaChavePrimaria) {
        this.sqlBuscaChavePrimaria = sqlBuscaChavePrimaria;
    }
    
    public String getSqlBusca() {
        return sqlBusca;
    }

    public void setSqlBusca(String sqlBusca) {
        this.sqlBusca = sqlBusca;
    }

    public String getSqlBuscaTodos() {
        return sqlBuscaTodos;
    }

    public void setSqlBuscaTodos(String sqlBuscaTodos) {
        this.sqlBuscaTodos = sqlBuscaTodos;
    }

    /**
     * @return id do elemento inserido
     */    
    @Override
    public Integer inserir(T t) {
        Connection c = ConexaoMySQL.getConexao();
        Integer id = null;
        try {
            PreparedStatement ps = c.prepareStatement(getSqlInsercao(), PreparedStatement.RETURN_GENERATED_KEYS);
            preencherInsercao(ps, t);
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
                id = rs.getInt(1); // pk
            rs.close();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(RelacionalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public void alterar(T t) {
        Connection c = ConexaoMySQL.getConexao();
        try {
            PreparedStatement ps = c.prepareStatement(getSqlAlteracao());
            preencherAlteracao(ps, t);
            ps.execute();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(RelacionalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(T t) {
        Connection c = ConexaoMySQL.getConexao();
        try {
            PreparedStatement ps = c.prepareStatement(getSqlExclusao());
            preencherExclusao(ps, t);
            ps.execute();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(RelacionalDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Collection<T> buscar(T t) {
        Connection c = ConexaoMySQL.getConexao();
        Collection<T> registros = new ArrayList<>();
        try {
            PreparedStatement ps = c.prepareStatement(getSqlBusca());
            preencherBusca(ps, t);
            ResultSet rs = ps.executeQuery();
            registros = preencherLista(rs);
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(RelacionalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;
    }
    
    @Override
    public T buscar(String id) {
        Connection c = ConexaoMySQL.getConexao();
        T registro = null;
        try {
            PreparedStatement ps = c.prepareStatement(getSqlBuscaChavePrimaria());
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) 
                registro = preencher(rs);
            rs.close();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(RelacionalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;
    }
    
    @Override
    public Collection<T> buscarTodos() {
        Connection c = ConexaoMySQL.getConexao();
        Collection<T> registros = null;
        try {
            PreparedStatement ps = c.prepareStatement(getSqlBuscaTodos());
            ResultSet rs = ps.executeQuery();
            registros = preencherLista(rs);
            ps.close();
            rs.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(RelacionalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return registros;
    }

    protected abstract void preencherInsercao(PreparedStatement ps, T t) throws SQLException;

    protected abstract void preencherAlteracao(PreparedStatement ps, T t) throws SQLException;

    protected abstract void preencherExclusao(PreparedStatement ps, T t) throws SQLException;

    protected abstract void preencherBusca(PreparedStatement ps, T t) throws SQLException;

    protected abstract T preencher(ResultSet rs) throws SQLException;

    protected abstract Collection<T> preencherLista(ResultSet rs) throws SQLException;
    
}
