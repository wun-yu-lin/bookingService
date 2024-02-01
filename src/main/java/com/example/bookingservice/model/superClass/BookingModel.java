package com.example.bookingservice.model.superClass;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@MappedSuperclass
@Data
public class BookingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "cargo", length = 100, nullable = false)
    protected String cargo;

    @Column(name = "quantity", nullable = false)
    protected int quantity;

    @Column(name = "loading", length = 50, nullable = false)
    protected String loading;

    @Column(name = "discharge", length = 50, nullable = false)
    protected String discharge;

    @Column(name= "created_time")
    protected Date createdTime = new Date();

}
