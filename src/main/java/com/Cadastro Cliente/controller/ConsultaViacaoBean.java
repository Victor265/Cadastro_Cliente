package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Viacao;
import com.algaworks.pedidovenda.repository.ViacaoDAO;

@Named
@ViewScoped
public class ConsultaViacaoBean implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject ViacaoDAO viacaoDAO;
	private List<Viacao> viacoes;
	private Viacao viacaoSelecionada;
	
	@PostConstruct
	public void init() {
		viacoes = viacaoDAO.consulta();

		
	}
	
	public void excluir() {
		try {
			
			viacaoDAO.excluir(viacaoSelecionada.getIdViacao());
			for(int i=0; i<viacoes.size(); i++){
				if(viacoes.get(i) == viacaoSelecionada) {
					viacoes.remove(i);
				}
			}
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Viação Excluida com Sucesso"));
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um problema "));
			e.printStackTrace();
		}
	}

	
	public List<Viacao> getViacoes() {
		return viacoes;
	}

	public void setViacoes(List<Viacao> viacoes) {
		this.viacoes = viacoes;
	}

	public Viacao getViacaoSelecionada() {
		return viacaoSelecionada;
	}

	public void setViacaoSelecionada(Viacao viacaoSelecionada) {
		this.viacaoSelecionada = viacaoSelecionada;
	}
	
}
