package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Carro;
import com.algaworks.pedidovenda.model.Viacao;
import com.algaworks.pedidovenda.repository.CarroDAO;
import com.algaworks.pedidovenda.repository.ViacaoDAO;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@ViewScoped
@Named
public class CarroBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject CarroDAO carroDAO;
	@Inject ViacaoDAO viacaoDAO;
	
	private Carro carro;
	private List<Viacao> viacoes;
	private Viacao viacaoSelecionada;
	
	
	@PostConstruct
	public void init() {
		String idCarro = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idCarro");
		String idViacao = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idViacao");
		
		this.viacoes = this.viacaoDAO.consulta();
		
		if( idCarro != null && idViacao != null) {
			int idCarro2 = Integer.parseInt(idCarro);
			int idViacao2 = Integer.parseInt(idViacao);
			
			carro = carroDAO.porId(idCarro2);
			viacaoSelecionada = viacaoDAO.porId(idViacao2);
		}else {
		
		carro= new Carro();
		viacoes = viacaoDAO.consulta();
	}
}
	
	public void salvar() {
		try {
			
			viacaoSelecionada = viacaoDAO.porId(viacaoSelecionada.getIdViacao());
			carro.setViacao(viacaoSelecionada);
			carroDAO.salvar(carro);
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Carro cadastrado com sucesso"));
			
		}catch(Exception e) {
			FacesUtil.addErrorMessage("Ocorreu um problema!!");
			e.printStackTrace();
		}
	}
	
	public void Limpar() {
		carro = new Carro();
		viacoes = viacaoDAO.consulta();
	}
	
	public Carro getCarro() {
		return carro;
	}
	
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	public List<Viacao> getViacoes(){
		return viacoes;
	}
	
	public void setViacoes (List<Viacao> viacoes) {
		this.viacoes = viacoes;
	}

	public Viacao getViacaoSelecionada() {
		return viacaoSelecionada;
	}

	public void setViacaoSelecionada(Viacao viacaoSelecionada) {
		this.viacaoSelecionada = viacaoSelecionada;
	}
	
}
