package com.algaworks.pedidovenda.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;



@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID=1L;
	
	//idGrupoConta,idConta e nCliente
	private ClienteId chavePrimaria;
	
	private Date dataHoje;	
	private String idCliente;
	private String nome;
	private String cpf;
	private String rg;
	private String endereco;
	private Date nascimento;
	private String telefoneR;
	private String telefoneC;
	private String email;
	private Date datadeCadastro;
	private Date ultimaVez;
	private String cep;
	private String bairro;
	private String cidade;
	private String uf;
	private String complemento;
	private String numero;
	

	

	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	
	@Column(nullable=false, length=30)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(nullable=false, length=14)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Column(nullable=false, length=12)
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
	@Column(nullable=false, length=50)
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	@Column( name="DataNascimento",nullable=false)
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	@Column(name="Telefone",nullable=false, length=13)
	public String getTelefoneR() {
		return telefoneR;
	}
	public void setTelefoneR(String telefoneR) {
		this.telefoneR = telefoneR;
	}
	@Column(name="Telefone2",nullable=false, length=14)
	public String getTelefoneC() {
		return telefoneC;
	}
	public void setTelefoneC(String telefoneC) {
		this.telefoneC = telefoneC;
	}
	@Column(nullable=false, length=30)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column( name="DataCadastro" ,nullable=false)
	public Date getDatadeCadastro() {
		return datadeCadastro;
	}
	public void setDatadeCadastro(Date datadeCadastro) {
		this.datadeCadastro = datadeCadastro;
	}
	
	
	public Date getUltimaVez() {
		return ultimaVez;
	}
	public void setUltimaVez(Date ultimaVez) {
		this.ultimaVez = ultimaVez;
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
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	@Column(name="End_Numero")
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name="idGrupoConta", column= @Column ( name="idGrupoConta", nullable=false)),
		@AttributeOverride(name="idConta", column= @Column ( name="idConta", nullable=false)),
		@AttributeOverride(name="nCliente", column= @Column ( name="nCliente", nullable=false))
		})	
	public ClienteId getChavePrimaria() {
		return chavePrimaria;
	}
	public void setChavePrimaria(ClienteId chavePrimaria) {
		this.chavePrimaria = chavePrimaria;
	}
	
	public Date getDataHoje() {
		return dataHoje;
	}
	public void setDataHoje(Date dataHoje) {
		this.dataHoje = dataHoje;
	}
	
}
