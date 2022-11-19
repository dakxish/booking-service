package com.myflight.book.bookingservice.controller.impl;

import com.myflight.book.bookingservice.controller.FlightBookingController;
import com.myflight.book.bookingservice.model.request.BookingRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Api(tags = "BookingService", description = "Service to book flight")
@RestController
@RequestMapping("/v1/api")
public class FlightBookingControllerImpl implements FlightBookingController {

    @Override
    @GetMapping("/book/{id}")
    public int getBookingId(@PathVariable int id) {
        if (id > 18)
            return id * 10;
        else
            return id * 100;
    }

    @Override
    @ApiOperation(value = "Book a flight", notes = "return a booking request id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created"),
            @ApiResponse(code = 409, message = "Booking already exist")
    })

    @PostMapping("/book")
    public ResponseEntity<String> createBooking(@RequestBody BookingRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("token", "Custom token generation");
        if (request.getFlightTime().isAfter(LocalDateTime.now()))
            return new ResponseEntity<>(UUID.randomUUID().toString(), headers, HttpStatus.CREATED);
        else {
            headers.remove("token");
            headers.add("toke", "Error while creating");
            return new ResponseEntity<>("not booked due to invalid booking date", headers, HttpStatus.CONFLICT);
        }
    }

    @Override
    @ApiOperation(value = "Update your Booking", notes = "Your Booking updated")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully updated"),
            @ApiResponse(code = 400, message = "Input data is invalid for update booking request")
    })
    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping("/book/{id}")
    public ResponseEntity<String> updateBookingRequest(@PathVariable int id, @RequestBody BookingRequest request) {
        if (request.getFlightTime().isAfter(LocalDateTime.now()))
            return new ResponseEntity<String>(UUID.randomUUID().toString(), HttpStatus.CREATED);
        else
            return new ResponseEntity<>("not booked due to invalid booking date", HttpStatus.BAD_REQUEST);
    }

    @Override
    @ApiOperation(value = "Delete the Booking Request", notes = "Record Deleted")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully Deleted")
    })
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable int id) {
        return new ResponseEntity<String>("Deleted", HttpStatus.OK);
    }
}
