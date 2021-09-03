package com.devsuperior.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;

	/**
	 * Esse endpoint consulta um recurso externo Worker usando o Feign
	 **/

	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workeId}/days/{days}")
	public ResponseEntity<Payment> findPayment(@PathVariable Long workeId, @PathVariable Integer days) {
		Payment payment = paymentService.getPayment(workeId, days);
		return ResponseEntity.ok().body(payment);
	}

	//implementação alternativa em casos de falha
	public ResponseEntity<Payment> getPaymentAlternative(Long workeId, Integer days) {
		Payment payment = new Payment("Bram", 400.0, days);
		return ResponseEntity.ok().body(payment);
	}
}
