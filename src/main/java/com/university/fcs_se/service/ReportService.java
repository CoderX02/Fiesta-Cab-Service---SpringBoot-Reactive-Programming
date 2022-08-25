package com.university.fcs_se.service;

import com.university.fcs_se.dto.BookingDto;
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
        Flux<Booking> bookings = bookingRepository.findAll();

        Mono<List<Booking>> booking_pickups = bookings
                .filter(booking -> booking.getBookingType().equals(BookingType.PICKUP))
                .collect(Collectors.toList());

        Flux<Booking> bookingPickupsFlux = booking_pickups.flatMapMany(Flux::fromIterable);

        return bookingPickupsFlux;

    }
    public Flux<Booking> getAllPickUpAndDropBookings(){
        Flux<Booking> bookings = bookingRepository.findAll();

        Mono<List<Booking>> booking_pickups = bookings
                .filter(booking -> booking.getBookingType().equals(BookingType.PICKANDDROP))
                .collect(Collectors.toList());

        Flux<Booking> bookingPickUpAndDropFlux = booking_pickups.flatMapMany(Flux::fromIterable);

        return bookingPickUpAndDropFlux;
    }


    public Mono<Map<String, List<Booking>>> getBookingPickupList_GroupedBySupervisorId() {

        Flux<Booking> bookings = bookingRepository.findAll();

        Mono<List<Booking>> booking_pickups = bookings
                .filter(booking -> booking.getBookingType().equals(BookingType.PICKUP))
                .collect(Collectors.toList());

        Flux<Booking> bookingPickupsFlux = booking_pickups.flatMapMany(Flux::fromIterable);

        Mono<Map<String, List<Booking>>> groupByVehicleId = bookingPickupsFlux.collect(Collectors.groupingBy(Booking::getVehicleId));

        Mono<Map<String, List<Booking>>> groupBySupervisorId = bookingPickupsFlux.collect(Collectors.groupingBy(Booking::getSupervisorId));
        return groupBySupervisorId;
    }

    public Mono<Map<String, List<Booking>>> getBookingPickupList_GroupedByVehicleId() {

        Flux<Booking> bookings = bookingRepository.findAll();

        Mono<List<Booking>> booking_pickups = bookings
                .filter(booking -> booking.getBookingType().equals(BookingType.PICKUP))
                .collect(Collectors.toList());

        Flux<Booking> bookingPickupsFlux = booking_pickups.flatMapMany(Flux::fromIterable);

        Mono<Map<String, List<Booking>>> groupByVehicleId = bookingPickupsFlux.collect(Collectors.groupingBy(Booking::getVehicleId));
        return groupByVehicleId;
    }


}
