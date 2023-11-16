/*
 Objetivo desta classe é criar uma conexão com o BD
e devolver para alguma parte do projeto BD.
 */
package util;

import com.mysql.jdbc.Connection;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class ConnectionFactory {
    
    public static final String DRIVER = "com.mysql.jdbc.Driver"; //faz a ponte com o BD
    public static final String URL = "jdbc:mysql://localhost:3306/todoapp2"; // jdbc:mysql://localhost:3306/todoapp2?characterEncoding=utf8";
    public static final String USER = "root";
    public static final String PASS = "";
    
    public static java.sql.Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
            
        }  catch (ClassNotFoundException | SQLException ex){
            throw new RuntimeException ("Erro de conexão com o Banco de Dados", ex);
        }        
    }
    
    public static void closeConnection (Connection connection){
        try{
            if (connection != null){
                connection.close();
            }

        }  catch(SQLException ex){
                throw new RuntimeException("Erro ao fechar o Banco de Dados", ex);
        }
    }
    
    public static void closeConnection (Connection connection,
                PreparedStatement statement, ResultSet resultSet){
        try{
            if (connection != null){
                connection.close();
            }
            
            if(statement != null){
                statement.close();
            }
            
            if(resultSet !=null){
                resultSet.close();
            }
        }   catch(Exception ex){
                throw new RuntimeException("Erro ao fechar o Banco de Dados", ex);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement) {
        closeConnection(connection);
        try {
            if (statement != null){
                statement.close();
            }        
        } catch(SQLException ex){
            throw new RuntimeException("Erro ao fechar a conexão com o Banco de "
                    + "Dados", ex);
        }
    }
    
}
