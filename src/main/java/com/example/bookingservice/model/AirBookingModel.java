package com.example.bookingservice.model;


import com.example.bookingservice.model.superClass.BookingModel;
import jakarta.persistence.*;

@Entity
@Table(name = "air_booking")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "air_booking_id")),
        @AttributeOverride(name = "loading", column = @Column(name = "airport_of_loading")),
        @AttributeOverride(name = "discharge", column = @Column(name = "airport_of_discharge"))

})
public class AirBookingModel extends BookingModel {
}
