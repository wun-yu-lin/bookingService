package com.example.bookingservice.dto;

import com.example.bookingservice.constant.BookingMode;
import lombok.Data;


@Data
public class BookingDto {
    BookingMode mode;
    String cargo;
    int quantity;
    String from;
    String to;
}
