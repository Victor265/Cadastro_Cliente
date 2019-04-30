package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Viacao;
import com.algaworks.pedidovenda.repository.ViacaoDAO;
import com.algaworks.pedidovenda.repository.filters.ViacaoFilter;

@Named
@ViewScoped
public class ConsultaViacaoBean2 implements Serializable {

	private static final long serialVersionUID=1L;
	
	@Inject ViacaoDAO viacaoDAO;
	private ViacaoFilter filtro;
	private List<Viacao> viacoes;

	
	public ConsultaViacaoBean2() {
		filtro = new ViacaoFilter();
		viacoes=new ArrayList<>();
	}
	
	public void pesquisarTodos() {
		viacoes=viacaoDAO.consulta();
	}
	public void pesquisar() {		
		viacoes=viacaoDAO.filtrados(filtro);
	}

	public ViacaoFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(ViacaoFilter filtro) {
		this.filtro = filtro;
	}

	public List<Viacao> getViacoes() {
		return viacoes;
	}

	public void setViacoes(List<Viacao> viacoes) {
		this.viacoes = viacoes;
	}

	
}
