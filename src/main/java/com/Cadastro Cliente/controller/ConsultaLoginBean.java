package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

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
public class ConsultaLoginBean implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject LoginUsuarioDAO loginUsuarioDAO;
	private List<LoginUsuario> logins;
	private LoginUsuario loginSelecionado;
	
	@PostConstruct
	public void init() {
		setLogins(loginUsuarioDAO.consulta());

		
	}
	
	public void excluir() {
		try {
			
			loginUsuarioDAO.excluir(loginSelecionado.getId());
			for(int i=0; i<logins.size(); i++){
				if(logins.get(i) == loginSelecionado) {
					logins.remove(i);
				}
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login Excluido com Sucesso"));
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um problema "));
			e.printStackTrace();
		}
	}

	public List<LoginUsuario> getLogins() {
		return logins;
	}

	public void setLogins(List<LoginUsuario> logins) {
		this.logins = logins;
	}

	public LoginUsuario getLoginSelecionado() {
		return loginSelecionado;
	}

	public void setLoginSelecionado(LoginUsuario loginSelecionado) {
		this.loginSelecionado = loginSelecionado;
	}
}
