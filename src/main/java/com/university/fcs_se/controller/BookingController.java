package com.university.fcs_se.controller;

import com.university.fcs_se.dto.BookingDto;
import com.university.fcs_se.service.BookingService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(
        value = "/Booking",
        produces = { MediaType.APPLICATION_JSON_VALUE})
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/AllBooking")
    public Flux<BookingDto> getAllBooking(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Mono<BookingDto> getBooking(@PathVariable String id){
        return bookingService.getBooking(id);
    }

    @PostMapping("/Save")
    public Mono<BookingDto> saveBooking(@RequestBody Mono<BookingDto> bookingDtoMono){
        return bookingService.saveBooking(bookingDtoMono);
    }

    @PutMapping("/Update/{id}")
    public Mono<BookingDto> updateBooking(@RequestBody Mono<BookingDto> bookingDtoMono,@PathVariable String id){
        return bookingService.updateBooking(bookingDtoMono,id);
    }
    @DeleteMapping("/Delete/{id}")
    public Mono<Void> deleteBooking(@PathVariable String id){
        return bookingService.deleteBooking(id);
    }
}
