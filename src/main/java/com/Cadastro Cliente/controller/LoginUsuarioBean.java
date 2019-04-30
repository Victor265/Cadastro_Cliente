package com.algaworks.pedidovenda.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.LoginUsuario;
import com.algaworks.pedidovenda.repository.LoginUsuarioDAO;

@Named
@ViewScoped
public class LoginUsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private LoginUsuario login;
	@Inject
	private LoginUsuarioDAO loginUsuarioDAO;

	@PostConstruct
	public void init() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

		if (id != null) {
			int id2 = Integer.parseInt(id);

			login = loginUsuarioDAO.buscaLoginporID(id2);
		} else {
			login = new LoginUsuario();
			Integer numero = (int) Math.round(((Math.random() * 100) + 100));
			login.setId(numero);
				
			}
		}
	

	public void salvar() {
		try {
			loginUsuarioDAO.salvar(login);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login Cadastrado com Sucesso"));
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public void limpar() {
		login = new LoginUsuario();
		Integer numero = (int) Math.round(((Math.random() * 100) + 100));
		login.setId(numero);
	}

	public LoginUsuario getLogin() {
		return login;
	}

	public void setLogin(LoginUsuario login) {
		this.login = login;
	}
}
