package com.cakeapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cakeapp.daos.CustomerDao;
import com.cakeapp.entities.Customer;

@Service
public class CustomerService {

	@Autowired private CustomerDao dao;
	
	public void registerCustomer(Customer cust) {
		dao.save(cust);
	}
	
	public Customer findByEmail(String email) {
		return dao.getById(email);
	}

	public List<Customer> allCustomers() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public Customer validate(String userid, String pwd) {
		Customer cc=dao.getById(userid);
		if(cc!=null && cc.getPwd().equals(pwd)) {
			return cc;
		}
		return null;
	}
	
	public boolean verifyUserId(String userid) {
		// TODO Auto-generated method stub
		return dao.getById(userid)!=null;
	}

	public void updateProfile(Customer cust) {
		// TODO Auto-generated method stub
		if(cust.getPwd().equals("") || cust.getPwd()==null) {
			cust.setPwd(dao.getById(cust.getEmail()).getPwd());
		}
		dao.save(cust);	
	}
}
