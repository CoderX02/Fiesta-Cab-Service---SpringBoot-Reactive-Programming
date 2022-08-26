package com.university.fcs_se.dto;


import com.university.fcs_se.entity.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String customerId;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String location;
    private int numberOfVehiclesBooked;
    private CustomerType type;
}
