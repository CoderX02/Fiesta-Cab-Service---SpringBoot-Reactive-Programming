package com.university.fcs_se.repo;


import com.university.fcs_se.entity.Supervisor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface SupervisorRepository extends ReactiveMongoRepository<Supervisor,String>{
}
