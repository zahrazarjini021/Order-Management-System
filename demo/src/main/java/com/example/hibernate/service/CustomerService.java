package com.example.hibernate.service;

import com.example.hibernate.entity.CustomerEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class CustomerService {


    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");


//    public CustomerDTO create(CustomerDTO customer) {
//
//        CustomerEntity entity = CustomerMapper.toEntity(customer);
//        CustomerEntity save = repository.save(entity);
//        CustomerDTO finalSaved = CustomerMapper.toDto(save);
//        return finalSaved;
//    }


    public CustomerEntity create(CustomerEntity customer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
        em.close();
        return customer;
    }

//    public List<CustomerDTO> getAll() {
//        List<CustomerEntity> customerEntities = repository.findAll();
//        List<CustomerDTO> finalCustomer = CustomerMapper.toDtoList(customerEntities);
//        return finalCustomer;
//    }

    public List<CustomerEntity> getAll() {
        EntityManager em = emf.createEntityManager();
        List<CustomerEntity> list = em.createQuery("from CustomerEntity", CustomerEntity.class).getResultList();
        em.close();
        return list;
    }


//    public Optional<CustomerDTO> getById(Integer id) {
//        Optional<CustomerEntity> customer = repository.findById(id);
//        Optional<CustomerDTO> finalCustomer = customer.map(CustomerMapper::toDto);
//        return finalCustomer;
//    }

    public Optional<CustomerEntity> getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        CustomerEntity c = em.find(CustomerEntity.class, id);
        em.close();
        return Optional.ofNullable(c);
    }
//
//    public CustomerDTO update(Integer id, CustomerDTO customerDetails) {
//
//        CustomerEntity entity = CustomerMapper.toEntity(customerDetails);
//        repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Customer not found"));
//
//        entity.setFirstName(customerDetails.getFirstName());
//        entity.setLastName(customerDetails.getLastName());
//        entity.setAge(customerDetails.getAge());
//        entity.setAddress(customerDetails.getAddress());
//        entity.setPhone(customerDetails.getPhone());
//
//        repository.save(entity);
//
//        CustomerDTO finalCustomer = CustomerMapper.toDto(entity);
//        return finalCustomer;
//    }


    public CustomerEntity update(Integer id, CustomerEntity newData) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        CustomerEntity customer = em.find(CustomerEntity.class, id);
        if (customer == null) {
            em.getTransaction().rollback();
            em.close();
            throw new RuntimeException("Customer not found");
        }

        customer.setFirstName(newData.getFirstName());
        customer.setLastName(newData.getLastName());
        customer.setAge(newData.getAge());
        customer.setAddress(newData.getAddress());
        customer.setPhone(newData.getPhone());

        em.merge(customer);
        em.getTransaction().commit();
        em.close();

        return customer;
    }


//    public void delete(Integer id) {
//        repository.deleteById(id);
//    }

    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        CustomerEntity existing = em.find(CustomerEntity.class, id);
        if (existing != null) {
            em.remove(existing);
        }

        em.getTransaction().commit();
        em.close();
    }
}
