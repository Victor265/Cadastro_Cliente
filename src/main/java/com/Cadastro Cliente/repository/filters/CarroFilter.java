package com.algaworks.pedidovenda.repository.filters;

import java.io.Serializable;

public class CarroFilter implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer idCarro;
	private String viacao;
	private String numeroCarro;
	private String linha;
	
	
	public Integer getIdCarro() {
		return idCarro;
	}
	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}
	public String getViacao() {
		return viacao;
	}
	public void setViacao(String viacao) {
		this.viacao = viacao;
	}
	public String getNumeroCarro() {
		return numeroCarro;
	}
	public void setNumeroCarro(String numeroCarro) {
		this.numeroCarro = numeroCarro;
	}
	public String getLinha() {
		return linha;
	}
	public void setLinha(String linha) {
		this.linha = linha;
	}
	
	

}
