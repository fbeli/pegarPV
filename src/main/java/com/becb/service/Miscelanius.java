package com.becb.service;

import org.springframework.stereotype.Service;

import com.becb.modelo.Dados;

@Service
public class Miscelanius {

	private static String  host = "https://api-sandbox.kmdevantagens.com.br/kmv/api/v1/posto?client_id=575d22b6d25e4df28f6a374d704dc8c2&client_secret=9b95092b64f34e328FB0FE9830054589&geolocalizacao=";
	private static String localizacao;
	
	public static String getHost(Dados dado ) {
		
		localizacao = "lat:"+ dado.getLatitude()+"|lng:"+dado.getLongitute()+"|distancia:2";
		
		return host+localizacao;
		
	}
}
