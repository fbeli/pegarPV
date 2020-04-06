package com.becb;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.becb.service.PegarPosto;

@SpringBootApplication
public class PegarPvApplication {

	@Autowired
	PegarPosto pegarPosto;
	private static String[]  argumentos;
	
	
	public static void main(String[] args) {
		argumentos = args;
		ConfigurableApplicationContext ctx = SpringApplication.run(PegarPvApplication.class, args);		
		 int exitCode = SpringApplication.exit(ctx, new ExitCodeGenerator() {
	           public int getExitCode() {
	               return 0;
	           }
	       });
	       System.exit(exitCode);
		
	}
	
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return pegarPosto.buscarPontoDeVenda(restTemplate, argumentos);	
		
	}
	
	public PegarPosto getPegarPosto() {
		return pegarPosto;
	}

	public void setPegarPosto(PegarPosto pegarPosto) {
		this.pegarPosto = pegarPosto;
	}



	

}
