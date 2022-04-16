package br.com.infox.dal;

import java.sql.*;

/**
 * @author Bruno
 */
public class ModuloConexao {

    // metodo responsavel por fazer a conexao com o banco
    public static Connection conector() {
        java.sql.Connection conexao = null;

        // a linha abaixo "chama" o driver
        String driver = "com.mysql.cj.jdbc.Driver";

        // Armazenando informaçoes referente ao banco
        String url = "jdbc:mysql://localhost:3306/dbinfox";
        String user = "root";
        String password = "*******";

        // Estabelecendo a conexao com banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            
            // a linha abaixo informa o erro de conexao
            //System.out.println(e);
            return null;
        }
    }
}
