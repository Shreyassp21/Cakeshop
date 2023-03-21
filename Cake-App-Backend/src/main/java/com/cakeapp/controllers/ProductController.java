package com.cakeapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cakeapp.entities.Product;
import com.cakeapp.models.ProductDTO;
import com.cakeapp.models.Response;
import com.cakeapp.services.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired private ProductService productService;
	
	@PostMapping
	public ResponseEntity<?> saveProduct(ProductDTO dto) {
		System.out.println(dto);
		Product product=ProductDTO.toEntity(dto);
		productService.addProduct(product,dto.getImage());
		return Response.success(product);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllProducts() {
		return Response.success(productService.allProducts());
	}
	
	@GetMapping("search")
	public ResponseEntity<?> findAllProducts(String searchtext) {
		System.out.println(searchtext);
		return Response.success(productService.allProducts(searchtext));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findProduct(@PathVariable("id")int id) {
		Product product=productService.findProductById(id);
		return Response.success(product);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id")int id) {
		productService.deleteProduct(id);
		return Response.success("Product deleted successfully");
	}
}
