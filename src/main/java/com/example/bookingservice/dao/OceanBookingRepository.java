package com.example.bookingservice.dao;

import com.example.bookingservice.model.OceanBookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OceanBookingRepository extends JpaRepository<OceanBookingModel, Integer> {
}
