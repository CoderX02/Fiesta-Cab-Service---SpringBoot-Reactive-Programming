package com.university.fcs_se.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("booking")
public class Booking {

    @Id
    private String bookingID;
    private BookingType bookingType;
    private String location;
    private String destination;
    private LocalDate date;
    private int noOfVehicles;
    private VehicleType vehicleType;
    private LocalDate dateToDeliver;
    private LocalDate returnDate;
    private Boolean isHireActive;
    private String supervisorId;
    private String customerId;


}
