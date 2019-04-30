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

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.repository.filters.ClienteFilter;

public class ClienteDAOfilter implements Serializable {

	private static final long serialVersionUID=1l;
	
	@Inject private EntityManager manager;
	
	public  List<Cliente> filtrados (ClienteFilter filtro){
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteriaQuery = builder.createQuery(Cliente.class);
		List<Predicate> predicates = new ArrayList<>();
		
		Root<Cliente> clienteRoot = criteriaQuery.from(Cliente.class);
		
		if (filtro.getIdGrupoConta() != null && filtro.getIdConta() != null && filtro.getnCliente() != null) {
			predicates.add(
					builder.equal(
							clienteRoot.get("chavePrimaria").get("idGrupoConta"), 
							filtro.getIdGrupoConta()
					));
			predicates.add(
					builder.equal(
							clienteRoot.get("chavePrimaria").get("idConta"), 
							filtro.getIdConta()
					));
			
			predicates.add(
					builder.equal(
							clienteRoot.get("chavePrimaria").get("nCliente"), 
							filtro.getnCliente()
					));
		}
		
		
		if(StringUtils.isNotBlank(filtro.getNome())) {
			predicates.add(builder.like(builder.lower(clienteRoot.get("nome")), 
					"%" + filtro.getNome().toLowerCase() + "%"));
		}
		
		if(StringUtils.isNotBlank(filtro.getCpf())) {
			predicates.add(builder.like(builder.lower(clienteRoot.get("cpf")), 
					"%" + filtro.getCpf().toLowerCase() + "%"));
		}
		
		if(StringUtils.isNotBlank(filtro.getBairro())) {
			predicates.add(builder.like(builder.lower(clienteRoot.get("bairro")), 
					"%" + filtro.getBairro().toLowerCase() + "%"));
		}
		
		if(StringUtils.isNotBlank(filtro.getCidade())) {
			predicates.add(builder.like(builder.lower(clienteRoot.get("cidade")), 
					"%" + filtro.getCidade().toLowerCase() + "%"));
		}
		criteriaQuery.select(clienteRoot);
		criteriaQuery.where(predicates.toArray(new Predicate[0]));
		criteriaQuery.orderBy(builder.asc(clienteRoot.get("nome")));
		
		TypedQuery<Cliente> query = manager.createQuery(criteriaQuery);
		return query.getResultList();
	}
}	
	

