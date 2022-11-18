package com.myflight.book.bookingservice.controller.impl;

import com.myflight.book.bookingservice.controller.FlightBookingController;
import com.myflight.book.bookingservice.model.request.BookingRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.UUID;

@Api(tags = "BookingService", description = "Service to book flight")
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
    @ApiOperation(value = "Book a flight", notes = "return a booking request id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created"),
            @ApiResponse(code= 409, message = "Booking already exist")
    })

    @PostMapping("/book")
    public String createBooking(@RequestBody BookingRequest request) {
        if(request.getFlightTime().isAfter( LocalDateTime.now()))
        return UUID.randomUUID().toString();
        else
            return "not booked due to invalid booking date";
    }

    @Override
    @ApiOperation(value = "Update your Booking", notes = "Your Booking updated")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully updated")
    })
    @PutMapping("/book/{id}")
    public String updateBookingRequest(@PathVariable int id, @RequestBody BookingRequest request) {
        if(request.getFlightTime().isAfter( LocalDateTime.now()))
            return UUID.randomUUID().toString();
        else
            return "not booked due to invalid booking date";
    }
}
