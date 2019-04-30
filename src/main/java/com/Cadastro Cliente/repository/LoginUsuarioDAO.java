package com.algaworks.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.algaworks.pedidovenda.model.LoginUsuario;

public class LoginUsuarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject private EntityManager manager;
	
	public void salvar(LoginUsuario login) {
		try {
			manager.getTransaction().begin();
			manager.merge(login);
			manager.getTransaction().commit();
		}catch(Exception e) {
			manager.getTransaction().rollback();
		}
	}
	
	public List<LoginUsuario> consulta() {
		return manager.createQuery("from LoginUsuario", LoginUsuario.class).getResultList();

	}
	
	public void excluir(Integer id) {

		try {
			manager.getTransaction().begin();
			LoginUsuario login = manager.find(LoginUsuario.class, id);
			
			manager.remove(login);
			manager.getTransaction().commit();

		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		}

	}
	
	public LoginUsuario buscaLoginporID(Integer id) {
		return manager.find(LoginUsuario.class, id);
	
	}

	public LoginUsuario porNome(String nome) {
		LoginUsuario login = null;
		
		try {
			login = this.manager.createQuery("from LoginUsuario where lower(nome) = :nome", LoginUsuario.class)
				.setParameter("nome", nome.toLowerCase()).getSingleResult();
		} catch (NoResultException e) {
			// nenhum usuário encontrado com o nome informado
		}
		
		return login;
	}
}
