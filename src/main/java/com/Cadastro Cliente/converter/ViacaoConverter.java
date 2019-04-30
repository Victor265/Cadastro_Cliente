package com.algaworks.pedidovenda.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.pedidovenda.model.Viacao;
import com.algaworks.pedidovenda.repository.ViacaoDAO;
import com.algaworks.pedidovenda.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Viacao.class)
public class ViacaoConverter implements Converter {

 private ViacaoDAO viacaoDAO;
 
	public ViacaoConverter() {
		this.viacaoDAO = (ViacaoDAO) CDIServiceLocator.getBean(ViacaoDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Viacao retorno = null;

		if (value != null) {
			retorno = this.viacaoDAO.porId(new Integer(value));
		}

		return retorno;
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Viacao) value).getIdViacao().toString();
		}
		return "";
	}


}
