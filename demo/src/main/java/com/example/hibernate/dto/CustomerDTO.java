package com.example.hibernate.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@JsonIgnoreProperties
public class CustomerDTO {

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private Integer age;
    @NonNull
    private String address;
    @NonNull
    private String phone;
}
