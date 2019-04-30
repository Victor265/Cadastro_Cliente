package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Carro;
import com.algaworks.pedidovenda.repository.CarroDAO;
import com.algaworks.pedidovenda.repository.filters.CarroFilter;

@Named
@ViewScoped
public class ConsultaCarroBean2 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject CarroDAO carroDAO;
	private CarroFilter filtro;
	private List<Carro> carros;
	
	public ConsultaCarroBean2() {
		filtro = new CarroFilter();
		carros = new ArrayList<>();
	}
	
	public void listarTodos() {
		carros = carroDAO.consultar();
	}
	
	public void pesquisar() {
		carros = carroDAO.filtrados(filtro);
	}

	public CarroFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(CarroFilter filtro) {
		this.filtro = filtro;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	
}
