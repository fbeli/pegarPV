package com.becb.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resposta {

	
	private List<Posto> postos;

	
	public List<Posto> getPostos() {
		return postos;
	}

	public void setPostos(List<Posto> postos) {
		this.postos = postos;
	}

	public String toString() {
		if(null!=postos && postos.size()>0)
			return "posto: "+postos.get(0).getNomeFantasia();
		return "";
		
	}
	public Resposta() {
	}

	
}
