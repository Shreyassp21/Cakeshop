package com.cakeapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cakeapp.models.OrderDTO;
import com.cakeapp.models.Response;
import com.cakeapp.services.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired private OrderService oservice;
	
	@PostMapping
	public ResponseEntity<?> saveOrder(@RequestBody OrderDTO dto) {
		System.out.println(dto);
		oservice.saveOrder(dto);;
		return Response.success("Order Placed successfully");
	}
	
	@GetMapping
	public ResponseEntity<?> findAllOrders() {
		return Response.success(oservice.allOrders());
	}
	
	@GetMapping("customer")
	public ResponseEntity<?> findCustomerOrders(String email) {
		return Response.success(oservice.customerOrders(email));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateStatus(@PathVariable("id") int id) {
		oservice.updateStatus(id);
		return Response.success("Order Confirmed");
	}
}
