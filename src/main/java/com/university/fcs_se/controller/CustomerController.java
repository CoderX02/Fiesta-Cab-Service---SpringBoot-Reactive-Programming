package com.university.fcs_se.controller;

import com.university.fcs_se.dto.CustomerDto;
import com.university.fcs_se.entity.Customer;
import com.university.fcs_se.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(
        value ="/Customers",
        produces = { MediaType.APPLICATION_JSON_VALUE})
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/allCustomers")
    public Flux<CustomerDto> getCustomers() {
        Flux<CustomerDto> customers = customerService.getCustomers();
        return customers;
    }



    @GetMapping("/{id}")
    public Mono<CustomerDto> getCustomer(@PathVariable String id) {
        Mono<CustomerDto> customer = customerService.getCustomer(id);
        return customer;
    }

    @GetMapping("/getByMobileNumber/{mobileNumber}")
    public Mono<List<Customer>> getCustomerByMobileNumber(@PathVariable String mobileNumber) {
        return customerService.getCustomerByMobileNumber(mobileNumber);
    }

    @PostMapping("/save")
    public Mono<CustomerDto> saveCustomer(@RequestBody Mono<CustomerDto> customerDtoMono){
        return customerService.saveCustomer(customerDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<CustomerDto> updateCustomer(@RequestBody Mono<CustomerDto> customerDtoMono,@PathVariable String id){
        return customerService.updateCustomer(customerDtoMono,id);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteCustomer(@PathVariable String id){
        return customerService.deleteCustomer(id);
    }

}
