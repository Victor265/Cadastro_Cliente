package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.repository.ClienteDAOfilter;
import com.algaworks.pedidovenda.repository.filters.ClienteFilter;

@Named
@ViewScoped
public class ConsultaBean2 implements Serializable {

	private static final long serialVersionUID=1L;
	
	@Inject ClienteDAOfilter clienteDAOfilter;
	private ClienteFilter filtro;
	private List<Cliente> clientes;

	
	public ConsultaBean2() {
		filtro = new ClienteFilter();
		clientes=new ArrayList<>();
		
	
	}
	
	public void pesquisar() {
		clientes=clienteDAOfilter.filtrados(filtro);
	}
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ClienteFilter getFiltro() {
		return filtro;
	}
	
	public void setFiltro(ClienteFilter filtro) {
		this.filtro=filtro;
	}
}
