package com.algaworks.pedidovenda.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Viacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false)
	private Integer idViacao;
	
	private String nome;
	private String cnpj;
	private String endereco;
	private String numero;
	private String bairro;
	private String cidade;
	private int numeroCarros;
	private String linhas;
	
	@ElementCollection(targetClass=String.class)
	private List<String> consorcio;
	
	
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
	public List<String> getConsorcio() {
		return consorcio;
	}
	public void setConsorcio(List<String> consorcio) {
		this.consorcio = consorcio;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idViacao == null) ? 0 : idViacao.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viacao other = (Viacao) obj;
		if (idViacao == null) {
			if (other.idViacao != null)
				return false;
		} else if (!idViacao.equals(other.idViacao))
			return false;
		return true;
	}
	

	
}
