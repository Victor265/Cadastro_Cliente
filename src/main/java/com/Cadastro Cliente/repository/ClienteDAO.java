package com.algaworks.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.ClienteId;

public class ClienteDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public void salvar(Cliente c) {
		/*
		 * EntityManagerFactory factory =
		 * Persistence.createEntityManagerFactory("PedidoPU"); EntityManager manager =
		 * factory.createEntityManager();
		 */

		try {
			manager.getTransaction().begin();
			manager.merge(c);
			
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}

	public List<Cliente> consulta() {
		return manager.createQuery("from Cliente", Cliente.class).getResultList();

	}

	public void excluir(ClienteId clienteid) {

		try {
			manager.getTransaction().begin();
			Cliente cliente = manager.find(Cliente.class, clienteid);
			
			manager.remove(cliente);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}

	}
	
	public Cliente buscaClienteporID(Integer idGrupoConta, Integer idConta, Integer nCliente) {
		ClienteId id = new ClienteId();
		id.setIdConta(idConta);
		id.setIdGrupoConta(idGrupoConta);
		id.setnCliente(nCliente);
		return manager.find(Cliente.class, id);
	
	}

}