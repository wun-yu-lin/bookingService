package com.example.bookingservice.controller;


import com.example.bookingservice.constant.BookingMode;
import com.example.bookingservice.dto.BookingDto;
import com.example.bookingservice.exception.DataNoFoundException;
import com.example.bookingservice.service.BookingService;
import com.example.bookingservice.vo.BookingVO;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private BookingService bookingService;


    //DI via constructor
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("")
    public ResponseEntity<BookingVO> getBookingByIdAndMode(
            @RequestParam(required = true) Integer id,
            @RequestParam(required = true) String mode
            ) throws DataNoFoundException {
            BookingMode bookingMode = BookingMode.valueOf(mode.toLowerCase());
        return ResponseEntity.ok(bookingService.getBookingByIdAndMode(id, bookingMode));

    }

    @PostMapping("")
    public ResponseEntity<String> PostBooking(
            @RequestBody BookingDto bookingDto
    ){
        bookingService.postBooking(bookingDto);
        return ResponseEntity.ok("success");
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteBooking(
            @RequestParam(required = true) Integer id,
            @RequestParam(required = true) String mode
    ){
        BookingMode bookingMode = BookingMode.valueOf(mode.toLowerCase());
        bookingService.deleteBookingByIdAndMode(id, bookingMode);
        return ResponseEntity.ok("success");
    }


}
