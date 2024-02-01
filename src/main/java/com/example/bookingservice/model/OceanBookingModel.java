package com.example.bookingservice.model;

import com.example.bookingservice.model.superClass.BookingModel;
import jakarta.persistence.*;


@Entity
@Table(name = "ocean_booking")

@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ocean_booking_id")),
        @AttributeOverride(name = "loading", column = @Column(name = "port_of_loading", length = 50, nullable = false)),
        @AttributeOverride(name = "discharge", column = @Column(name = "port_of_discharge", length = 50, nullable = false))
})
public class OceanBookingModel extends BookingModel {
}
