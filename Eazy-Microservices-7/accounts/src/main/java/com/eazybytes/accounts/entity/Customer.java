package com.eazybytes.accounts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Customer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String  customerId;

    private String name;

    private String email;

    private String mobileNumber;

//    @PrePersist
//    public void prePersist(){
//        if(customerId == null)
//            customerId = UUID.randomUUID().toString();
//    }
}
