package com.university.fcs_se.dto;

import com.university.fcs_se.entity.VehicleType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {
    private String registrationNumber;
    private String model;
    private VehicleType vehicleType;
}
