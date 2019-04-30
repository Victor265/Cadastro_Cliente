package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.ClienteId;
import com.algaworks.pedidovenda.repository.ClienteDAO;

@Named
@ViewScoped
public class CadastroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	@Inject
	private ClienteDAO clienteDao;

	@PostConstruct
	public void init() {
		//pegando paramêtros
		String idGrupoConta = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idGrupoConta");
		String idConta = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idConta");
		String nCliente = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("nCliente");

		//convertendo paramêtros para inteiro

		if (idGrupoConta != null && idConta != null && nCliente != null) {

			int idGrupoConta2 = Integer.parseInt(idGrupoConta);
			int idConta2 = Integer.parseInt(idConta);
			int nCliente2 = Integer.parseInt(nCliente);
			
			//Long idGrupoContaLong = Long.parseLong(idGrupoConta);
			
		
			
			cliente = clienteDao.buscaClienteporID(idGrupoConta2, idConta2, nCliente2);
		} else {

			cliente = new Cliente();
			cliente.setDataHoje(new Date());
			
			
			ClienteId id = new ClienteId();
			id.setIdGrupoConta(1);
			id.setIdConta(999);
			cliente.setDatadeCadastro(new Date());
			Integer numero = (int) Math.round(((Math.random() * 100) + 100));
			id.setnCliente(numero);

			cliente.setChavePrimaria(id);
		
		}
	}

	public void salvar() {

		try {
			clienteDao.salvar(cliente);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil Cadastrado com Sucesso"));
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public void limpar() {
		cliente = new Cliente();
		cliente.setDataHoje(new Date());
		
		ClienteId id = new ClienteId();
		id.setIdGrupoConta(1);
		id.setIdConta(999);
		cliente.setDatadeCadastro(new Date());
		Integer numero = (int) Math.round(((Math.random() * 100) + 100));
		id.setnCliente(numero);

		cliente.setChavePrimaria(id);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
