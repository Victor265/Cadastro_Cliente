package com.algaworks.pedidovenda.repository.filters;

import java.io.Serializable;

public class ViacaoFilter implements Serializable{

	private static final long serialVersionUID=1l;
	
	private Integer idViacao;
	private String nome;
	private String cnpj;
	private String endereco;
	private String numero;
	private String bairro;
	private String cidade;
	private int numeroCarros;
	private String linhas;
	private String consorcio;
	
	
	public Integer getIdViacao() {
		return idViacao;
	}
	public void setIdViacao(Integer idViacao) {
		this.idViacao = idViacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getNumeroCarros() {
		return numeroCarros;
	}
	public void setNumeroCarros(int numeroCarros) {
		this.numeroCarros = numeroCarros;
	}
	public String getLinhas() {
		return linhas;
	}
	public void setLinhas(String linhas) {
		this.linhas = linhas;
	}
	public String getConsorcio() {
		return consorcio;
	}
	public void setConsorcio(String consorcio) {
		this.consorcio = consorcio;
	}	
}
