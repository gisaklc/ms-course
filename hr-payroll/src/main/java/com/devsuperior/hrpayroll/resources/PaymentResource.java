package com.devsuperior.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;

	@GetMapping(value = "/{workeId}/days/{days}")
	public ResponseEntity<Payment> findPayment(@PathVariable Long workeId, @PathVariable Integer days) {
		Payment payment = paymentService.getPayment(workeId, days);
		return ResponseEntity.ok().body(payment);
	}

}
