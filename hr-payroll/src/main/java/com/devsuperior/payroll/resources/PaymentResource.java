package com.devsuperior.payroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.payroll.entities.Payment;
import com.devsuperior.payroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
	@Autowired
	private PaymentService service;
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		return ResponseEntity.ok(service.getPayment(workerId, days));
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {
		Payment payment = new Payment("Teste", 500.0, 10);
		return ResponseEntity.ok(payment);
	}
}
