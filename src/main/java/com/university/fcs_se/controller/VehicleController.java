package com.university.fcs_se.controller;

import com.university.fcs_se.dto.VehicleDto;
import com.university.fcs_se.service.VehicleService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(
        value ="/Vehicle",
        produces = { MediaType.APPLICATION_JSON_VALUE})
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/AllVehicles")
    public Flux<VehicleDto> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public Mono<VehicleDto> getVehicles(@PathVariable String id){
        return vehicleService.getVehicle(id);
    }

    @PostMapping("/Save")
    public Mono<VehicleDto> saveVehicle(@RequestBody Mono<VehicleDto> vehicleDtoMono){
        return vehicleService.saveVehicle(vehicleDtoMono);
    }

    @PutMapping("/Update/{id}")
    public Mono<VehicleDto> updateVehicle(@RequestBody Mono<VehicleDto> vehicleDtoMono,@PathVariable String id){
        return vehicleService.updateVehicle(vehicleDtoMono,id);
    }

    @DeleteMapping("/Delete/{id}")
    public Mono<Void> deleteVehicle(@PathVariable String id){
        return vehicleService.deleteVehicle(id);
    }

}
