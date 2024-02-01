package com.example.bookingservice.vo;


import com.example.bookingservice.constant.BookingMode;
import lombok.Data;

@Data
public class BookingVO {
    BookingMode mode;
    String cargo;
    int quantity;
    String from;
    String to;
}
