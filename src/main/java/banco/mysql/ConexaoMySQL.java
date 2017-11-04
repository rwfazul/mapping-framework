/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author isabella
 */
public class ConexaoMySQL {
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String SENHA = "1234";
    static final String USUARIO = "root";
    static final String URL_CONEXAO = "jdbc:mysql://localhost/PGBD?useSSL=false";
        
    public static Connection getConexao() throws Exception {
        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
        return conn;
    }
     
}
