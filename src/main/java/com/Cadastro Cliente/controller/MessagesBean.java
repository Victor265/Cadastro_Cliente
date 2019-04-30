package com.algaworks.pedidovenda.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class MessagesBean {

	public void adicionarMensagemErro() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
				"Resumo da Mensagem de Erro","Mensagem de Erro Completa");
		context.addMessage("destinoErro", msg);
	}
	
	public void adicionarAvisoFlutuante() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Resumo do aviso Flutuante","Aviso Flutuante Completo");
		context.addMessage("destinoAviso", msg);
	
	}
}
