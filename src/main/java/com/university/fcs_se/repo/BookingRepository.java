package com.university.fcs_se.repo;

import com.university.fcs_se.entity.Booking;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface BookingRepository extends ReactiveMongoRepository<Booking, String> {
}
