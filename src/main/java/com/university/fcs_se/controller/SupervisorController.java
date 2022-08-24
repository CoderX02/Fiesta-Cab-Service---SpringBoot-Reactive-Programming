package com.university.fcs_se.controller;

import com.university.fcs_se.dto.SupervisorDto;
import com.university.fcs_se.service.SupervisorService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Supervisor")
public class SupervisorController {

    private final SupervisorService service;

    public SupervisorController(SupervisorService service) {
        this.service = service;
    }

    @GetMapping("/AllSupervisors")
    public Flux<SupervisorDto> getAllSupervisor() {
        return service.getAllSupervisor();
        //TODO : Udara is coding
    }

    @GetMapping("/{id}")
    public Mono<SupervisorDto> getSupervisor(@PathVariable String id){
        return service.getSupervisor(id);
    }

    @PostMapping("/Save")
    public Mono<SupervisorDto> saveSupervisor(@RequestBody Mono<SupervisorDto> supervisorDtoMono){
        return service.saveSupervisor(supervisorDtoMono);
    }

    @PutMapping("/Update/{id}")
    public Mono<SupervisorDto> updateSupervisor(@RequestBody  Mono<SupervisorDto> supervisorDtoMono, @PathVariable String id){
        return service.updateSupervisor(supervisorDtoMono,id);
    }

    @DeleteMapping("/Delete/{id}")
    public Mono<Void> deleteSupervisor(@PathVariable String id) {
        return service.deleteSupervisor(id);
    }
}
