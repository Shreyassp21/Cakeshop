package com.cakeapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cakeapp.daos.ProductDao;
import com.cakeapp.entities.Product;
import com.cakeapp.utils.StorageService;

@Service
public class ProductService {
	@Autowired private ProductDao dao;
	@Autowired private StorageService storageService;
	
	public void addProduct(Product p,MultipartFile image) {
		// TODO Auto-generated method stub
		String photo=storageService.store(image);
		p.setPhoto(photo);
		dao.save(p);
	}
	
	public List<Product> allProducts() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Direction.DESC,"prodid"));
	}
	
	public List<Product> allProducts(String searchtext) {
		// TODO Auto-generated method stub
		return dao.findByPnameLike(searchtext);
	}
	
	public Product findProductById(int id) {
		return dao.getById(id);
	}
	
	public void deleteProduct(int id) {
		Product prod=dao.getById(id);
		dao.delete(prod);
	}
}
