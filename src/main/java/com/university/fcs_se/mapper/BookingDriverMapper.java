package com.university.fcs_se.mapper;

import com.university.fcs_se.dto.BookingDto;
import com.university.fcs_se.dto.DriverDto;
import com.university.fcs_se.entity.Driver;
import com.university.fcs_se.repo.DriverRepository;
import com.university.fcs_se.utils.BookingAppUtils;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

public class BookingDriverMapper {
    private final DriverRepository driverRepository;

    public BookingDriverMapper(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }


    public boolean isDriverAvailable(Mono<BookingDto> bookingDtoMono) {

        String driverId = bookingDtoMono.map(BookingDto::getDriverId).block();

        Driver assignedDriver = driverRepository.findById(driverId)
                .filter(driver -> driver.getIsAssigned().equals(true))
                .block();

        if (assignedDriver.getDriverId().isEmpty()) {
            return true;
        }
        else{
            return false;
        }
    }
}
