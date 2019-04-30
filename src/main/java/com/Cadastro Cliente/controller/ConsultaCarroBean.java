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
import com.algaworks.pedidovenda.repository.CarroDAO;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class ConsultaCarroBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject CarroDAO carroDAO;
	
	private Carro carroSelecionado;
	private List<Carro> carros;
	
	@PostConstruct
	public void init() {
		carros = carroDAO.consultar();
	}
	
	public void excluir() {
		try {
			carroDAO.excluir(carroSelecionado.getIdCarro());
			for(int i=0; i<carros.size(); i++) {
				if(carros.get(i) == carroSelecionado) {
					carros.remove(i);
				}
			}
			
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Carro Excluido com Sucesso!!"));
		}catch(Exception e) {
			FacesUtil.addErrorMessage("Ocorreu um problema");
			e.printStackTrace();
		}
	}
	
	public Carro getCarroSelecionado() {
		return carroSelecionado;
	}
	
	public void setCarroSelecionado(Carro carroSelecionado) {
		this.carroSelecionado = carroSelecionado;
	}
	
	public List<Carro> getCarros(){
		return carros;
	}
	
	public void setCarros(List<Carro> carros) {
		this.carros=carros;
	}
}
