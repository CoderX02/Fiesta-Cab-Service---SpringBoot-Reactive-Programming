package com.university.fcs_se.mapper;

import com.university.fcs_se.dto.BookingDto;
import com.university.fcs_se.dto.SupervisorDto;
import com.university.fcs_se.entity.Supervisor;
import reactor.core.publisher.Mono;

public class BookingSupervisorMapper {
    public Mono<BookingDto>  supervisorIdVerifying(Mono<BookingDto> bookingDtoMono) {
//        bookingDtoMono.flatMap()
        return null;
    };
};
