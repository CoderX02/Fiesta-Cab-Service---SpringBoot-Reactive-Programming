package com.university.fcs_se.service;

import com.university.fcs_se.dto.CustomerDto;
import com.university.fcs_se.entity.Customer;
import com.university.fcs_se.repo.CustomerRepository;
import com.university.fcs_se.utils.CustomerAppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Flux<CustomerDto> getCustomers(){
        return repository.findAll().map(CustomerAppUtils::entityToDTo);
    };

    public Mono<CustomerDto> getCustomer(String id) {
        return repository.findById(id).map(CustomerAppUtils::entityToDTo);
    }

    public Mono<List<Customer>> getCustomerByMobileNumber(String mobileNumber) {
        return repository.findAll()
                .filter(customer -> customer.getMobileNumber()
                        .equals(mobileNumber)).collect(Collectors.toList());
    }

    public Mono<CustomerDto> saveCustomer(Mono<CustomerDto> customerDtoMono){



        return customerDtoMono.map(CustomerAppUtils::dtoToEntity)
                .flatMap(repository::insert)
                .map(CustomerAppUtils::entityToDTo);
    }

    public Mono<CustomerDto> updateCustomer(Mono<CustomerDto> customerDtoMono,String id){
        return repository.findById(id)
                .flatMap(p->customerDtoMono.map(CustomerAppUtils::dtoToEntity)
                .doOnNext(e->e.setCustomerId(id)))
                .flatMap(repository::save)
                .map(CustomerAppUtils::entityToDTo);
    }

    public Mono<Void> deleteCustomer(String id){
        return repository.deleteById(id);
    }

}
