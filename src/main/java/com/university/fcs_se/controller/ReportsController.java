package com.university.fcs_se.controller;

import com.university.fcs_se.entity.Booking;
import com.university.fcs_se.service.ReportService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(
        value = "/Reports",
        produces = { MediaType.APPLICATION_JSON_VALUE})
public class ReportsController {

    private final ReportService reportService;

    public ReportsController(ReportService reportService) {
        this.reportService = reportService;
    }


    @GetMapping("/AllPickupBookings")
    public Flux<Booking> getAllPickupBookings() {
        return reportService.getAllPickUpBookings();
    }

    @GetMapping("/AllPickupAndDropBookings")
    public Flux<Booking> getAllPickupAndDropBookings() {
        return reportService.getAllPickUpAndDropBookings();
    }

    @GetMapping("/GroupedBySupervisorId")
    public Mono<Map<String, List<Booking>>> getBookingPickupList_GroupedBySupervisorId() {
        return reportService.getBookingPickupList_GroupedBySupervisorId();
    }

    @GetMapping("/GroupedByVehicleId")
    public Mono<Map<String, List<Booking>>> getBookingPickupList_GroupedByVehicleId() {
        return reportService.getBookingPickupList_GroupedByVehicleId();
    }



}
