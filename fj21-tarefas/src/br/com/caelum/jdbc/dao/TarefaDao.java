package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.modelo.Tarefa;

public class TarefaDao {
	
	private Connection connection;
	
	public TarefaDao(Connection connection) {
		this.connection = connection;
	}
	
	public void adiciona(Tarefa tarefa){
		String sql = "insert into contato (?, ?, ?, ?) values (?,?,?,?)";
		
		try {
	        // prepared statement para inserção
	        PreparedStatement stmt = connection.prepareStatement(sql);

	        // seta os valores


	        // executa
	        stmt.execute();
	        stmt.close();
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}

	public List<Tarefa> getLista() {
		try{
			PreparedStatement stmt = connection.prepareStatement("select * from ?");
	
			// executa um select
			ResultSet rs = stmt.executeQuery();
	
			// itera no ResultSet
			
			ArrayList<Tarefa> tarefas = new ArrayList<>();
			while (rs.next()) {
				//adiciona a lista
			}
			rs.close();
			stmt.close();
			return tarefas;
		}catch (Exception e){ 
			throw new RuntimeException(e);
		}
	}

	public void altera(Tarefa tarefa) {
	     String sql = "update contatos set ?=?, ?=?, ?=?, ?=? where id=?";
	     try {
	         PreparedStatement stmt = connection.prepareStatement(sql);
	         //seta os valores
	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	public void delete(Tarefa tarefa) {
		try {
	         PreparedStatement stmt = connection.prepareStatement("delete from ? where id=?");

	         stmt.execute();
	         stmt.close();
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	}

}
