package com.devsuperior.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;

/**
 * Foi criado so o service pois esse projeto nao terá bancos de dados Anotado
 * como @Component ou @Service para ser injetado em outras classes
 **/
@Service
public class PaymentService {

//	@Autowired
//	private WorkerFeignClient workerFeignClient;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${hr-worker.host}") // recupera o caminho do arquivo properties
	private String host;

//	public Payment getPayment(long workerId, int days) {
//		// Worker worker = workerFeignClient.findById(workerId).getBody();
//		return new Payment("Bob", 200.0, days);
//		// return new Payment(worker.getName(), worker.getDailyIncome(), days);
//	}

	
	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+ workerId); // pra referenciar com o {id} da url
		Worker worker = restTemplate.getForObject(host + "/workes/{id}", Worker.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);

	}

}
