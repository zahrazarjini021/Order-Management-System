package com.example.hibernate.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "UUID", nullable = false, unique = true, updatable = false)
    private String uuid;

    @NonNull
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NonNull
    @Column(name = "LAST_NAME")
    private String lastName;

    @NonNull
    @Column(name = "AGE")
    private Integer age;

    @NonNull
    @Column(name = "ADDRESS")
    private String address;

    @NonNull
    @Column(name = "PHONE_NUMBER")
    private String phone;

    public CustomerEntity() {
        this.uuid = UUID.randomUUID().toString();
    }

}
