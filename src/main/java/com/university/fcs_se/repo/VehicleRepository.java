package com.university.fcs_se.repo;

import com.university.fcs_se.entity.Vehicle;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends ReactiveMongoRepository<Vehicle,String> {
}
