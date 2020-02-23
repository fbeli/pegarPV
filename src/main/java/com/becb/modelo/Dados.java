package com.becb.modelo;

public class Dados {

	
	
	
	private String id;
	private String latitude;
	private String longitute;
	
	
	
	public Dados(String linha) {
		String[] dados = linha.split(",");
		if(dados.length >2) {
			setId(dados[0]);
			setLatitude(dados[1]);
			setLongitute(dados[2]);
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitute() {
		return longitute;
	}
	public void setLongitute(String longitute) {
		this.longitute = longitute;
	}
	
	
	
}
