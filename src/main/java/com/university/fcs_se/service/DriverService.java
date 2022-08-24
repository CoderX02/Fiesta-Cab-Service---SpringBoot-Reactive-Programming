package com.university.fcs_se.service;

import com.university.fcs_se.dto.DriverDto;
import com.university.fcs_se.repo.DriverRepository;
import com.university.fcs_se.utils.DriverAppUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DriverService {
    private final DriverRepository repository;

    public DriverService(DriverRepository repository) {
        this.repository = repository;
    }
    public Flux<DriverDto> getAllDrivers(){
        return repository.findAll().map(DriverAppUtils::entityToDTo);
    }

    public Mono<DriverDto> getDriver(String id){
        return repository.findById(id).map(DriverAppUtils::entityToDTo);
    }

    public Mono<DriverDto> updateDriver(Mono<DriverDto> driverDtoMono, String id){
        return repository.findById(id)
                .flatMap(p ->driverDtoMono.map(DriverAppUtils::dtoToEntity))
                .doOnNext(e->e.setDriverId(id))
                .flatMap(repository::save)
                .map(DriverAppUtils::entityToDTo);
    }

    public Mono<DriverDto> saveDriver(Mono<DriverDto> driverDtoMono){
        return driverDtoMono.map(DriverAppUtils::dtoToEntity)
                .flatMap(repository::insert)
                .map(DriverAppUtils::entityToDTo);

    }
    public Mono<Void> deleteDriver(String id){
        return repository.deleteById(id);
    }
}