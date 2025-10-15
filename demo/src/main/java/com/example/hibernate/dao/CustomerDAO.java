package com.example.hibernate.dao;

import com.example.hibernate.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO  extends JpaRepository<CustomerEntity, Integer> {


}
