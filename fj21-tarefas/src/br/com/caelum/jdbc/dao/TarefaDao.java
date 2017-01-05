package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.modelo.Tarefa;

public class TarefaDao {

	private Connection connection;

	public TarefaDao(Connection connection) {
		this.connection = connection;
	}

	public void adiciona(Tarefa tarefa){
		String sql = "Insert into tarefa (descricao, finalizado, dataFinalizacao) values(?, ?, ?)";

		try{
			PreparedStatement stmt =  connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setDate(3, new Date(System.currentTimeMillis()));
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public Tarefa buscaPorId(Long id){
		try{
			PreparedStatement stmt = connection.prepareStatement("select * from tarefa where id=?");

			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			rs.first();

			Tarefa tarefa = new Tarefa();
			tarefa.setId(rs.getLong("id"));
			tarefa.setDescricao(rs.getString("descricao"));
			tarefa.setFinalizado(rs.getBoolean("finalizado"));

			Calendar data = Calendar.getInstance(); 
			data.setTime(rs.getDate("dataFinalizacao"));
			tarefa.setDataFinalizacao(data);

			rs.close();
			stmt.close();
			return tarefa;
		}catch (Exception e){ 
			throw new RuntimeException(e);
		}
	}

	public List<Tarefa> getLista() {
		try{
			PreparedStatement stmt = connection.prepareStatement("select * from tarefa");

			// executa um select
			ResultSet rs = stmt.executeQuery();

			// itera no ResultSet

			ArrayList<Tarefa> tarefas = new ArrayList<>();
			while (rs.next()) {
				//adiciona a lista
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));

				Calendar data = Calendar.getInstance(); 
				data.setTime(rs.getDate("dataFinalizacao"));
				tarefa.setDataFinalizacao(data);

				tarefas.add(tarefa);
			}
			rs.close();
			stmt.close();
			return tarefas;
		}catch (Exception e){ 
			throw new RuntimeException(e);
		}
	}

	public void altera(Tarefa tarefa) {
		String sql = "update tarefa set descricao=?, finalizado=?, dataFinalizacao=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			stmt.setLong(4, tarefa.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(Tarefa tarefa) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from tarefa where id=?");
			stmt.setLong(1, tarefa.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void finaliza(Long id){
		String sql = "update tarefa set finalizado=?, dataFinalizacao=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setBoolean(1, true);
			stmt.setDate(2, new Date(System.currentTimeMillis()));
			stmt.setLong(3, id);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
