package com.example.bookingservice.service;

import com.example.bookingservice.constant.BookingMode;
import com.example.bookingservice.dto.BookingDto;
import com.example.bookingservice.exception.DataNoFoundException;
import com.example.bookingservice.vo.BookingVO;

public interface BookingService {

    BookingVO getBookingByIdAndMode(int bookingId, BookingMode mode) throws DataNoFoundException;

    void postBooking(BookingDto bookingDto);

    void deleteBookingByIdAndMode(int bookingId, BookingMode mode);

}
