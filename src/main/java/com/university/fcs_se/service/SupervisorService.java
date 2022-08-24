package com.university.fcs_se.service;

import com.university.fcs_se.dto.SupervisorDto;
import com.university.fcs_se.repo.SupervisorRepository;
import com.university.fcs_se.utils.SupervisorAppUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SupervisorService {
    private final SupervisorRepository repository;

    public SupervisorService(SupervisorRepository repository) {
        this.repository = repository;
    }

    public Flux<SupervisorDto> getAllSupervisor(){
        return repository.findAll().map(SupervisorAppUtils::entityToDTo);
    };

    public Mono<SupervisorDto> getSupervisor(String id) {
        return repository.findById(id).map(SupervisorAppUtils::entityToDTo);
    }

    public Mono<SupervisorDto> saveSupervisor(Mono<SupervisorDto> supervisorDtoMono){
        return supervisorDtoMono.map(SupervisorAppUtils::dtoToEntity)
                .flatMap(repository::insert)
                .map(SupervisorAppUtils::entityToDTo);
    }

    public Mono<SupervisorDto> updateSupervisor(Mono<SupervisorDto> supervisorDtoMono,String id){
        return repository.findById(id)
                .flatMap(p->supervisorDtoMono.map(SupervisorAppUtils::dtoToEntity)
                        .doOnNext(e->e.setSupervisorId(id)))
                .flatMap(repository::save)
                .map(SupervisorAppUtils::entityToDTo);
    }

    public Mono<Void> deleteSupervisor(String id){
        return repository.deleteById(id);
    }
}
