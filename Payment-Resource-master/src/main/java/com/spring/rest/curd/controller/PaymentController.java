package com.spring.rest.curd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.curd.dto.PaymentResponse;
import com.spring.rest.curd.model.Payment;
import com.spring.rest.curd.service.PaymentService;

@RestController
@RequestMapping("/paymentResource")
public class PaymentController {
	@Autowired
	private PaymentService service;
	
//http://localhost:9091/payment-resource/paymentResource/payNow
	@PostMapping("/payNow")
	public PaymentResponse payInstant(@RequestBody Payment payment) {
		System.out.println("Contorllet  for Post methos is calling");
		return service.pay(payment);
	}
	
	//http://localhost:9091/payment-resource/paymentResource/getTransactionByVendor/Phonepay

	@GetMapping("/getTransactionByVendor/{vendor}")
	public PaymentResponse getTransaction(@PathVariable String vendor) {
		System.out.println("Contorllet for get methos is calling");
		return service.getTx(vendor);
	}

}
