package com.university.fcs_se.service;

import com.university.fcs_se.dto.BookingDto;
import com.university.fcs_se.mapper.BookingSupervisorMapper;
import com.university.fcs_se.repo.BookingRepository;
import com.university.fcs_se.utils.BookingAppUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookingService{

    private BookingSupervisorMapper bookingSupervisorMapper;
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Flux<BookingDto> getAllBookings(){
        return bookingRepository.findAll().map(BookingAppUtils::entityToDto);
    }

    public Mono<BookingDto> getBooking(String id){
        return bookingRepository.findById(id).map(BookingAppUtils::entityToDto);
    }

    public Mono<BookingDto> saveBooking(Mono<BookingDto> bookingDtoMono) {
//        bookingSupervisorMapper.supervisorLinking(bookingDtoMono);
        return bookingDtoMono.map(BookingAppUtils::dtoToEntity)
                .flatMap(bookingRepository::insert)
                .map(BookingAppUtils::entityToDto);

    }
    public Mono<BookingDto> updateBooking(Mono<BookingDto> bookingDtoMono,String id){
        return bookingRepository.findById(id)
                .flatMap(p-> bookingDtoMono.map(BookingAppUtils::dtoToEntity))
                .doOnNext(e->e.setBookingID(id))
                .flatMap(bookingRepository::save)
                .map(BookingAppUtils::entityToDto);
    }

    public Mono<Void> deleteBooking(String id) {
        return bookingRepository.deleteById(id);
    }
}
