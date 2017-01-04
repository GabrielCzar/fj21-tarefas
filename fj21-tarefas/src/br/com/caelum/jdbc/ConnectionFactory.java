package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;

public class ConnectionFactory {
	
    public Connection getConnection() throws ServletException {
    	final String DRIVER = "com.mysql.jdbc.Driver"; 
    	final String URL = "jdbc:mysql://localhost:3306/tarefas";
    	final String USER = "root";
    	final String PASS = "root";
    	
        try {
        	Class.forName(DRIVER);
        	System.out.println("Conexao estabelecida");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
        	throw new ServletException(e);
		}
    }
}