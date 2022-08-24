package com.university.fcs_se.service;

import com.university.fcs_se.dto.VehicleDto;
import com.university.fcs_se.repo.VehicleRepository;
import com.university.fcs_se.utils.VehicleAppUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Flux<VehicleDto> getAllVehicles(){
        return vehicleRepository.findAll().map(VehicleAppUtils::entityToDto);
    }

    public Mono<VehicleDto> getVehicle(String id){
        return vehicleRepository.findById(id).map(VehicleAppUtils::entityToDto);
    }

    public Mono<VehicleDto> saveVehicle(Mono<VehicleDto> vehicleDtoMono){
        return vehicleDtoMono.map(VehicleAppUtils::dtoToEntity)
                .flatMap(vehicleRepository::insert)
                .map(VehicleAppUtils::entityToDto);
    }

    public Mono<VehicleDto> updateVehicle(Mono<VehicleDto> vehicleDtoMono,String id){
        return vehicleRepository.findById(id)
                .flatMap(p-> vehicleDtoMono.map(VehicleAppUtils::dtoToEntity))
                .doOnNext(e-> e.setRegistrationNumber(id))
                .flatMap(vehicleRepository::save)
                .map(VehicleAppUtils::entityToDto);

    }

    public Mono<Void> deleteVehicle(String id){
        return vehicleRepository.deleteById(id);
    }


}
