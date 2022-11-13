package com.myflight.book.bookingservice.controller.impl;

import com.myflight.book.bookingservice.controller.FlightBookingController;
import com.myflight.book.bookingservice.model.request.BookingRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api")
public class FlightBookingControllerImpl implements FlightBookingController {

    @Override
    @GetMapping("/book/{id}")
    public int getBookingId(@PathVariable int id) {
       if(id > 18)
           return id * 10;
       else
           return id * 100;
    }

    @Override
    @PostMapping("/book")
    public String createBooking(@RequestBody BookingRequest request) {
        if(request.getFlightTime().isAfter( LocalDateTime.now()))
        return UUID.randomUUID().toString();
        else
            return "not booked due to invalid booking date";
    }
}
