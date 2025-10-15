package com.example.hibernate.mapper;

import com.example.hibernate.dto.CustomerDTO;
import com.example.hibernate.entity.CustomerEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static CustomerDTO toDto(CustomerEntity entity) {
        if (entity == null) return null;

        CustomerDTO dto = new CustomerDTO();

        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setAge(entity.getAge());
        dto.setAddress(entity.getAddress());
        dto.setPhone(entity.getPhone());

        return dto;
    }

    public static CustomerEntity toEntity(CustomerDTO dto) {
        if (dto == null) return null;

        CustomerEntity entity = new CustomerEntity();

        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAge(dto.getAge());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());

        return entity;
    }

    public static List<CustomerDTO> toDtoList(List<CustomerEntity> entities) {
        if (entities == null) return null;
        return entities.stream().map(CustomerMapper::toDto).collect(Collectors.toList());
    }

    public static List<CustomerEntity> toEntityList(List<CustomerDTO> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(CustomerMapper::toEntity).collect(Collectors.toList());
    }

}
