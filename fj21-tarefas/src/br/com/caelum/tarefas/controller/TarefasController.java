package br.com.caelum.tarefas.controller;

import java.sql.Connection;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.dao.TarefaDao;
import br.com.caelum.jdbc.modelo.Tarefa;

@Controller
public class TarefasController {
	
	@RequestMapping("novaTarefa")
	public String form(){
		return "tarefa/formulario";
	}
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(Tarefa tarefa) throws ServletException {
		
		Connection connection = new ConnectionFactory().getConnection();
		TarefaDao tarefaDao = new TarefaDao(connection);
		tarefaDao.adiciona(tarefa);
		
		return "tarefa/adicionada";
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model) throws ServletException
	{	
		Connection connection = new ConnectionFactory().getConnection();
		TarefaDao dao = new TarefaDao(connection);
		model.addAttribute("tarefas", dao.getLista());
	
		return "tarefa/lista";
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) throws ServletException {
		 Connection connection = new ConnectionFactory().getConnection();
		 TarefaDao dao = new TarefaDao(connection);
		 dao.delete(tarefa);
		  
		 return "redirect:listaTarefas";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) throws ServletException {
		Connection connection = new ConnectionFactory().getConnection();
		TarefaDao dao = new TarefaDao(connection);	
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/mostra";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) throws ServletException {
		Connection connection = new ConnectionFactory().getConnection();
		TarefaDao dao = new TarefaDao(connection);
		dao.altera(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, Model model) throws ServletException {
		Connection connection = new ConnectionFactory().getConnection();
		TarefaDao dao = new TarefaDao(connection);
		dao.finaliza(id);
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/dataFinalizada";
		//response.setStatus(200);
	}

}
