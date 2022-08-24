package com.university.fcs_se.repo;

import com.university.fcs_se.entity.Driver;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends ReactiveMongoRepository<Driver, String> {
}
