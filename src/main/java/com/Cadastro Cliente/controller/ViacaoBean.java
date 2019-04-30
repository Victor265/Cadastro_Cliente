package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Viacao;
import com.algaworks.pedidovenda.repository.ViacaoDAO;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class ViacaoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject ViacaoDAO viacaoDAO;
	private Viacao viacao;
	
	
	@PostConstruct
	public void Init() {
		String idViacao = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idViacao");
		
		if(idViacao !=null) {
			int idViacao2 = Integer.parseInt(idViacao);
			
			viacao = viacaoDAO.porId(idViacao2);
		}else {
		
		viacao = new Viacao();
		List <String> consorcio = new ArrayList<String>();
        	consorcio.add("Internorte");
        	consorcio.add("Intersul");
        	consorcio.add("Santa Cruz");
        	consorcio.add("Transcarioca");
        	viacao.setConsorcio(consorcio);
		}
	}
	
	public void salvar() {
		try{ 
			viacaoDAO.salvar(viacao);
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Viação Cadastrada com Sucesso"));
	}catch(Exception e) {
		FacesUtil.addErrorMessage("Ocorreu um problema");
		e.printStackTrace();
	}
		
	}
	
	public void limpar() {
		 viacao = new Viacao();
		 List <String> consorcio = new ArrayList<String>();
	        consorcio.add("Internorte");
	        consorcio.add("Intersul");
	        consorcio.add("Santa Cruz");
	        consorcio.add("Transcarioca");
	        viacao.setConsorcio(consorcio);
	}

	public Viacao getViacao() {
		return viacao;
	}
	
	public void setViacao(Viacao viacao) {
		this.viacao=viacao;
	}
	
}
