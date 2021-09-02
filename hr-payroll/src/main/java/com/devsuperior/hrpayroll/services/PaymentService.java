package com.devsuperior.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feingClients.WorkerFeingClient;

/**
 * Foi criado so o service pois esse projeto nao terá bancos de dados Anotado
 * como @Component ou @Service para ser injetado em outras classes
 **/
@Service
public class PaymentService {

	@Autowired
	private WorkerFeingClient workerFeingClient;

	
	public Payment getPayment(long workerId, int days) {
		//busca o trabalhador usando o feeing
		Worker worker = workerFeingClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);

	}

}
