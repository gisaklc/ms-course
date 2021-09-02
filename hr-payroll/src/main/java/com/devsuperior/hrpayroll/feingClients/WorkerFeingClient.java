package com.devsuperior.hrpayroll.feingClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.devsuperior.hrpayroll.entities.Worker;

/**
 * Interface com as assinaturas das requisicoes pra chamar os web services
 * externo. Usando o FEING o codigo fica mais limpo e é integrado com as outras
 * ferramentas do spring.
 * 
**/

@Component
@FeignClient(name = "hr-worker",  path = "/workers")
public interface WorkerFeingClient {
	// declara o tipo de chamada WB
	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id);
}
