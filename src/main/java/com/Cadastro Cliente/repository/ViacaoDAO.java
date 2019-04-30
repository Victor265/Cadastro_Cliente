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


import com.algaworks.pedidovenda.model.Viacao;
import com.algaworks.pedidovenda.repository.filters.ViacaoFilter;

public class ViacaoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject EntityManager manager;
	
	public Viacao porId(Integer idViacao) {
		return manager.find(Viacao.class, idViacao);
	}
	
	public void salvar(Viacao viacao) {
		try {
			manager.getTransaction().begin();
			manager.merge(viacao);
			manager.getTransaction().commit();
		}catch(Exception e) {
			manager.getTransaction().rollback();
		}
	}
	
	public List<Viacao> consulta(){
		return manager.createQuery("from Viacao",Viacao.class ).getResultList();
	}
	
	public void excluir(Integer idViacao) {
		try {
			manager.getTransaction().begin();
			Viacao viacao = manager.find(Viacao.class, idViacao );
			manager.remove(viacao);
			manager.getTransaction().commit();
		}catch(Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	
	public List<Viacao> filtrados(ViacaoFilter filtro) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Viacao> criteriaQuery = builder.createQuery(Viacao.class);
		List<Predicate> predicates = new ArrayList<>();
		
		Root<Viacao> viacaoRoot = criteriaQuery.from(Viacao.class);
		
		if (filtro.getIdViacao() != null) {
			predicates.add(builder.equal(viacaoRoot.get("idViacao"), filtro.getIdViacao()));
		}
		
		if(StringUtils.isNotBlank(filtro.getNome())) {
			predicates.add(builder.like(builder.lower(viacaoRoot.get("nome")), 
					"%" + filtro.getNome().toLowerCase() + "%"));
		}
		
		if(StringUtils.isNotBlank(filtro.getLinhas())) {
			predicates.add(builder.like(builder.lower(viacaoRoot.get("linhas")),
					"%" + filtro.getLinhas().toLowerCase() + "%"));
		}
		
		
		criteriaQuery.select(viacaoRoot);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		criteriaQuery.orderBy(builder.asc(viacaoRoot.get("idViacao")));
		
		TypedQuery<Viacao> query = manager.createQuery(criteriaQuery);
		return query.getResultList();
		
	}
}
