package com.university.fcs_se.service;

import com.university.fcs_se.entity.Booking;
import com.university.fcs_se.entity.BookingType;
import com.university.fcs_se.repo.BookingRepository;
import com.university.fcs_se.repo.DriverRepository;
import com.university.fcs_se.repo.VehicleRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final BookingRepository bookingRepository;
    private final VehicleRepository vehicleRepository;
    private final DriverRepository driverRepository;

    public ReportService(BookingRepository bookingRepository, VehicleRepository vehicleRepository, DriverRepository driverRepository) {
        this.bookingRepository = bookingRepository;
        this.vehicleRepository = vehicleRepository;
        this.driverRepository = driverRepository;
    }

    public Flux<Booking> getAllPickUpBookings(){

        Flux<Booking> bookingPickupsFlux = bookingRepository.findAll()
                .filter(booking -> booking.getBookingType().equals(BookingType.PICKUP))
                .collect(Collectors.toList())
                .flatMapMany(Flux::fromIterable);

        return bookingPickupsFlux;

    }
    public Flux<Booking> getAllPickUpAndDropBookings(){
        Flux<Booking> bookingPickUpAndDrop  = bookingRepository.findAll()
                .filter(booking -> booking.getBookingType().equals(BookingType.PICKANDDROP))
                .collect(Collectors.toList())
                .flatMapMany(Flux::fromIterable);


        return bookingPickUpAndDrop;
    }


    public Mono<Map<String, List<Booking>>> getBookingPickupList_GroupedBySupervisorId() {

        Mono<Map<String, List<Booking>>> bookingsGroupBySupervisorId  = bookingRepository.findAll()
                .filter(booking -> booking.getBookingType().equals(BookingType.PICKUP))
                .collect(Collectors.toList())
                .flatMapMany(Flux::fromIterable)
                .collect(Collectors.groupingBy(Booking::getSupervisorId));

//        Mono<Map<String, List<Booking>>> groupBySupervisorId = booking_pickups.collect(Collectors.groupingBy(Booking::getSupervisorId));
        return bookingsGroupBySupervisorId;
    }

    public Mono<Map<String, List<Booking>>> getBookingPickupList_GroupedByVehicleId() {

        Mono<Map<String, List<Booking>>> groupByVehicleId = bookingRepository.findAll()
                .filter(booking -> booking.getBookingType().equals(BookingType.PICKUP))
                .collect(Collectors.toList())
                .flatMapMany(Flux::fromIterable)
                .collect(Collectors.groupingBy(Booking::getVehicleId));

        return groupByVehicleId;
    }


}
