package com.algaworks.pedidovenda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ClienteId implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Integer idGrupoConta;
	private Integer idConta;
	private Integer nCliente;
	
	@Column(name="idGrupoConta", nullable=false, length=11)
	public Integer getIdGrupoConta() {
		return idGrupoConta;
	}
	public void setIdGrupoConta(Integer idGrupoConta) {
		this.idGrupoConta = idGrupoConta;
	}
	@Column(name="idConta", nullable=false, length=11)
	public Integer getIdConta() {
		return idConta;
	}
	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}
	@Column(name="nCliente", nullable=false, length=11)
	public Integer getnCliente() {
		return nCliente;
	}
	public void setnCliente(Integer nCliente) {
		this.nCliente = nCliente;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idConta == null) ? 0 : idConta.hashCode());
		result = prime * result + ((idGrupoConta == null) ? 0 : idGrupoConta.hashCode());
		result = prime * result + ((nCliente == null) ? 0 : nCliente.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteId other = (ClienteId) obj;
		if (idConta == null) {
			if (other.idConta != null)
				return false;
		} else if (!idConta.equals(other.idConta))
			return false;
		if (idGrupoConta == null) {
			if (other.idGrupoConta != null)
				return false;
		} else if (!idGrupoConta.equals(other.idGrupoConta))
			return false;
		if (nCliente == null) {
			if (other.nCliente != null)
				return false;
		} else if (!nCliente.equals(other.nCliente))
			return false;
		return true;
	}
	
	
	
	
}
