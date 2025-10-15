package com.example.hibernate.service;

import com.example.hibernate.dao.CustomerDAO;
import com.example.hibernate.dto.CustomerDTO;
import com.example.hibernate.entity.CustomerEntity;
import com.example.hibernate.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    private final CustomerDAO repository;

    @Autowired
    public CustomerService(CustomerDAO repository) {
        this.repository = repository;
    }

    public CustomerDTO create(CustomerDTO customer) {

        CustomerEntity entity = CustomerMapper.toEntity(customer);
        CustomerEntity save = repository.save(entity);
        CustomerDTO finalSaved = CustomerMapper.toDto(save);
        return finalSaved;
    }

    public List<CustomerDTO> getAll() {
        List<CustomerEntity> customerEntities = repository.findAll();
        List<CustomerDTO> finalCustomer = CustomerMapper.toDtoList(customerEntities);
        return finalCustomer;
    }

    public Optional<CustomerDTO> getById(Integer id) {
        Optional<CustomerEntity> customer = repository.findById(id);
        Optional<CustomerDTO> finalCustomer = customer.map(CustomerMapper::toDto);
        return finalCustomer;
    }

    public CustomerDTO update(Integer id, CustomerDTO customerDetails) {


        CustomerEntity entity = CustomerMapper.toEntity(customerDetails);
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        entity.setFirstName(customerDetails.getFirstName());
        entity.setLastName(customerDetails.getLastName());
        entity.setAge(customerDetails.getAge());
        entity.setAddress(customerDetails.getAddress());
        entity.setPhone(customerDetails.getPhone());

        repository.save(entity);

        CustomerDTO finalCustomer = CustomerMapper.toDto(entity);
        return finalCustomer;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
