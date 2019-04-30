package com.algaworks.pedidovenda.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.algaworks.pedidovenda.model.Carro;
import com.algaworks.pedidovenda.repository.filters.CarroFilter;

public class CarroDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject EntityManager manager;
	
	public void salvar(Carro carro) {
		try {
			manager.getTransaction().begin();
			manager.merge(carro);
			manager.getTransaction().commit();
			
		}catch(Exception e) {
			manager.getTransaction().rollback();
		}
	}
	
	public List<Carro> consultar(){
		return manager.createQuery("from Carro",Carro.class).getResultList();
	}
	
	public Carro porId(Integer idCarro) {
		return manager.find(Carro.class, idCarro);
	}
	
	public void excluir(Integer idCarro) {
		try {
			manager.getTransaction().begin();
			Carro  carro = manager.find(Carro.class, idCarro);
			manager.remove(carro);
			manager.getTransaction().commit();
		}catch(Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	
	public List<Carro> filtrados(CarroFilter filtro){
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		List<Predicate> predicates = new ArrayList<>();
		Root<Carro> carroRoot = criteriaQuery.from(Carro.class);
		
		if(filtro.getIdCarro() !=null ) {
			predicates.add(builder.equal(carroRoot.get("idCarro"), filtro.getIdCarro()));
		}
		
		if(StringUtils.isNotBlank(filtro.getViacao())) {
			predicates.add(builder.like(builder.lower(carroRoot.get("viacao").get("nome")), "%" +
					filtro.getViacao().toLowerCase() + "%"));
		}
		
		if(StringUtils.isNotBlank(filtro.getNumeroCarro())) {
			predicates.add(builder.like(builder.lower(carroRoot.get("numeroCarro")), "%" +
					filtro.getNumeroCarro().toLowerCase() + "%"));
		}
		
		if(StringUtils.isNotBlank(filtro.getLinha())) {
			predicates.add(builder.like(builder.lower(carroRoot.get("linha")), "%" +
					filtro.getLinha().toLowerCase() + "%"));
		}
		
		criteriaQuery.select(carroRoot);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		criteriaQuery.orderBy(builder.asc(carroRoot.get("idCarro")));
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		return query.getResultList();
	}
}
