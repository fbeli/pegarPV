package com.becb.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.becb.PegarPvApplication;
import com.becb.modelo.Dados;
import com.becb.modelo.Resposta;

@Service
public class PegarPosto {

	private String pathServico = "https://api-sandbox.kmdevantagens.com.br/kmv/api/v1/posto?client_id=575d22b6d25e4df28f6a374d704dc8c2&client_secret=9b95092b64f34e328FB0FE9830054589&geolocalizacao=lat:-22.9076830|lng:-43.2190790|distancia:2";

	private static final Logger log = LoggerFactory.getLogger(PegarPosto.class);
	
	@Autowired
	Arquivos arquivos;
	
	
	

	
	private String arquivoEntrada;
	private String arquivoSaida;
	
	private String getNomeArquivos(String[] args) {
		if(null!= args && args.length >0)
			for (int i = 0; i < args.length; i++) {
				if(args[i].contains("entrada:")){
					arquivoEntrada = args[i].replace("entrada:", "");
					System.out.println("Lndo de arquivo: "+arquivoEntrada);
				}
				else if(args[i].contains("saida:")){
					arquivoSaida = args[i].replace("saida:", "");
					System.out.println("Escrevendo em arquivo: "+arquivoSaida);
				}
			}
		
		return "";
	}
	
	public CommandLineRunner buscarPontoDeVenda(RestTemplate restTemplate, String[] args) throws Exception {
		
		getNomeArquivos(args);
		
		if(null == arquivoEntrada)
			arquivoEntrada = "lista.csv";
		if( null == arquivoSaida)
			arquivoSaida = "saida.csv";
		
		List<Dados> dados = arquivos.lerArquivo(arquivoEntrada,arquivoSaida);
		
		for (Dados dado : dados) {
			pathServico = Miscelanius.getHost(dado);
			
			Resposta resposta = restTemplate.getForObject(
					pathServico, Resposta.class);
			arquivos.salvarDados(resposta.getPostos(), dado, arquivoSaida);		
			
			log.info(resposta.toString());			
			
		}
		
		return xuxu -> {
			
		};
	}




	public Arquivos getArquivos() {
		return arquivos;
	}




	public void setArquivos(Arquivos arquivos) {
		this.arquivos = arquivos;
	}

}
