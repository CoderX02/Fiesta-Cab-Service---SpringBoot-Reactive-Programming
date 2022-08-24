package com.university.fcs_se.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("Vehicle")
public class Vehicle {
    @Id
    private String registrationNumber;
    private String model;
    private VehicleType vehicleType;
}
