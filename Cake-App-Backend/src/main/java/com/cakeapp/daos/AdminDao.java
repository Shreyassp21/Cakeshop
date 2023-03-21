package com.cakeapp.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cakeapp.entities.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, String> {

}
