package com.university.fcs_se.controller;

import com.university.fcs_se.dto.DriverDto;
import com.university.fcs_se.service.DriverService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@RestController
@RequestMapping("/Driver")
public class DriverController {

    private final DriverService driverService;



    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/Save")
    public Mono<DriverDto> saveDriver(@RequestBody Mono<DriverDto> driverDtoMono){
        return driverService.saveDriver(driverDtoMono);
    }

    @GetMapping("/GetAllDrivers")
    public Flux<DriverDto> getAllDrivers() {
        return driverService.getAllDrivers();
    }
    @GetMapping("/findDriver/{id}")
    public Mono<DriverDto> getAllDrivers(@PathVariable String id) {
        return driverService.getDriver(id);
    }

    @PutMapping("/Update/{id}")
    public Mono<DriverDto> updateDriver(@RequestBody Mono<DriverDto> driverDtoMono,@PathVariable String id){
        return driverService.updateDriver(driverDtoMono,id);
    }

    @DeleteMapping("/Delete/{id}")
    public Mono<Void> deleteDriver(@PathVariable String id){
        return driverService.deleteDriver(id);
    }


}
