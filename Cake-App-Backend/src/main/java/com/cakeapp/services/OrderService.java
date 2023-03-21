package com.cakeapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cakeapp.daos.OrderRepository;
import com.cakeapp.entities.Customer;
import com.cakeapp.entities.Order;
import com.cakeapp.models.OrderDTO;

@Service
public class OrderService {

	@Autowired private CustomerService csrv;
	@Autowired private ProductService psrv;
	@Autowired private OrderRepository repo;
	
	public void saveOrder(OrderDTO dto) {
		Order order=OrderDTO.toEntity(dto);
		order.setCustomer(csrv.findByEmail(dto.getEmail()));
		order.setProduct(psrv.findProductById(dto.getProdid()));
		repo.save(order);
	}
	
	public List<Order> allOrders(){
		return repo.findAll();
	}
	
	public List<Order> customerOrders(String email){
		return repo.findByCustomer(csrv.findByEmail(email));
	}
	
	public void updateStatus(int id) {
		Order order=repo.getById(id);
		order.setStatus("Delivered");
		repo.save(order);
	}
}
