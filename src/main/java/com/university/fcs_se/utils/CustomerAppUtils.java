package com.university.fcs_se.utils;

import com.university.fcs_se.dto.CustomerDto;
import com.university.fcs_se.entity.Customer;
import org.springframework.beans.BeanUtils;

public class CustomerAppUtils {

    public static CustomerDto entityToDTo(Customer customer){

        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
        return customerDto;
    }

    public static Customer dtoToEntity(CustomerDto customerDto){

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        return customer;
    }

}
