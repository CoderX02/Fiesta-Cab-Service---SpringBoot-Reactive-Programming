package com.university.fcs_se.dto;

import com.university.fcs_se.entity.BookingType;
import com.university.fcs_se.entity.Subsidiary;
import com.university.fcs_se.entity.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private String bookingID;
    private BookingType bookingType;
    private String location;
    private Subsidiary subsidiary;
    private String destination;
    private LocalDate date;
    private VehicleType vehicleType;
    private LocalDate dateToDeliver;
    private LocalDate returnDate;
    private Boolean isHireActive;
    private String supervisorId;
    private String customerId;
    private String vehicleId;
    private String driverId;
}
