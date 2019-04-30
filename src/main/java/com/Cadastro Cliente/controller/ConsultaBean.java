package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.repository.ClienteDAO;

@Named
@ViewScoped
public class ConsultaBean implements Serializable {

	private static final long serialVersionUID=1L;
	
	@Inject ClienteDAO clienteDAO;
	private List<Cliente> clientes ;
private Cliente clienteSelecionado;
	
	@PostConstruct
	public void init() {
		setClientes(clienteDAO.consulta());

		
	}
	
	public void excluir() {
		try {
			
			clienteDAO.excluir(clienteSelecionado.getChavePrimaria());
			for(int i=0; i<clientes.size(); i++){
				if(clientes.get(i) == clienteSelecionado) {
					clientes.remove(i);
				}
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente Excluido com Sucesso"));
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um problema "));
			e.printStackTrace();
		}
	}

	
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}
	
	
}
