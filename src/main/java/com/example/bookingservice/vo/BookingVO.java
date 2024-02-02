package com.example.bookingservice.vo;


import com.example.bookingservice.constant.BookingMode;
import lombok.Data;

@Data
public class BookingVO {
   private int id;
   private BookingMode mode;
   private String cargo;
   private int quantity;
   private String from;
   private String to;
}
