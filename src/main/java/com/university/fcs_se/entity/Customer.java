package com.university.fcs_se.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
public class Customer {
    @Id
    private String customerId;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String location;
    private int numberOfVehiclesBooked;
    private CustomerType type;

}



