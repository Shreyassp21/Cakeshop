package com.cakeapp.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	private int quantity;
	private int amount;
	private LocalDate deliverydate;
	private LocalDate orderdate;
	private String status;
	private String caketext;
	
	public Order() {
		// TODO Auto-generated constructor stub
		this.orderdate=LocalDate.now();
		this.status="Pending";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public LocalDate getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(LocalDate deliverydate) {
		this.deliverydate = deliverydate;
	}
	public LocalDate getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCaketext() {
		return caketext;
	}
	public void setCaketext(String caketext) {
		this.caketext = caketext;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", product=" + product + ", quantity=" + quantity
				+ ", amount=" + amount + ", deliverydate=" + deliverydate + ", orderdate=" + orderdate + ", status="
				+ status + ", caketext=" + caketext + "]";
	}
	
	
}
