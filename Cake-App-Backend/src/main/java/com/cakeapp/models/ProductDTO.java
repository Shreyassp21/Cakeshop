package com.cakeapp.models;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cakeapp.entities.Product;

public class ProductDTO extends Product {

	private MultipartFile image;

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	public static Product toEntity(ProductDTO dto) {
		Product entity=new Product();
		BeanUtils.copyProperties(dto, entity, "image");		
		return entity;
	}
}
