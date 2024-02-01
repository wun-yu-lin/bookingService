package com.example.bookingservice.dao;

import com.example.bookingservice.model.AirBookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirBookingRepository extends JpaRepository<AirBookingModel, Integer> {
}
