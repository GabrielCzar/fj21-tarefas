package br.com.caelum.jdbc.modelo;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.internal.NotNull;

public class Tarefa {
	
	private Long id;
	private String descricao;
	private boolean finalizado;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataFinalizacao;
	
	public Tarefa() {}
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	@NotNull
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public boolean isFinalizado() {
		return finalizado;
	}
	
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}
	
	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
}


