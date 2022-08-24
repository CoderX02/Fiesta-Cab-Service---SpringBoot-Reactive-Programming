package com.university.fcs_se.utils;


import com.university.fcs_se.dto.VehicleDto;
import com.university.fcs_se.entity.Vehicle;
import org.springframework.beans.BeanUtils;

public class VehicleAppUtils {

    public static VehicleDto entityToDto(Vehicle vehicle){
        VehicleDto vehicleDto = new VehicleDto();
        BeanUtils.copyProperties(vehicle,vehicleDto);
        return vehicleDto;
    }

    public static Vehicle dtoToEntity(VehicleDto vehicleDto){
        Vehicle vehicle = new Vehicle();
        BeanUtils.copyProperties(vehicleDto,vehicle);
        return vehicle;
    }
}
