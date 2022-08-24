package com.university.fcs_se.utils;

import com.university.fcs_se.dto.BookingDto;
import com.university.fcs_se.entity.Booking;
import org.springframework.beans.BeanUtils;

public class BookingAppUtils {

    public static BookingDto entityToDto(Booking booking){
        BookingDto bookingDto = new BookingDto();
        BeanUtils.copyProperties(booking,bookingDto);
        return bookingDto;
    }

    public static Booking dtoToEntity(BookingDto bookingDto){
        Booking booking = new Booking();
        BeanUtils.copyProperties(bookingDto,booking);
        return booking;
    }

}
