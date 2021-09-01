package com.devsuperior.hrpayroll.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	/**
	 * Este metodo serve para registrar uma instancia UNICA o SINGLETON de um objeto
	 * do Tipo ResTemplate para injetar em outros componentes criar componente a
	 * partir de chamada de metodo usando o @bean "
	 **/

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
