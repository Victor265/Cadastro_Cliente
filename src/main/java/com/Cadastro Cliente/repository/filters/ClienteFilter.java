package com.algaworks.pedidovenda.repository.filters;

import java.io.Serializable;

public class ClienteFilter implements Serializable{

	private static final long serialVersionUID=1l;
	
	private Long idGrupoConta;
	private Long idConta;
	private Long nCliente;
	private String nome;
	private String cpf;
	private String bairro;
	private String cidade;
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf=cpf;
	}
	
	public void setBairro(String bairro) {
		this.bairro=bairro;
	}
	
	public void setCidade(String cidade) {
		this.cidade=cidade;
	}

	public Long getIdGrupoConta() {
		return idGrupoConta;
	}

	public void setIdGrupoConta(Long idGrupoConta) {
		this.idGrupoConta = idGrupoConta;
	}

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public Long getnCliente() {
		return nCliente;
	}

	public void setnCliente(Long nCliente) {
		this.nCliente = nCliente;
	}
	
	
}
