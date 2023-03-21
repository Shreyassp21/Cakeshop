package com.cakeapp.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cakeapp.entities.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

	@Query(value = "select * from product where pname like %?1%",nativeQuery = true)
	List<Product> findByPnameLike(String pname);
}
