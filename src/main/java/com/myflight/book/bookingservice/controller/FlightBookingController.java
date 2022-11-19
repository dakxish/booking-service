package com.myflight.book.bookingservice.controller;

import com.myflight.book.bookingservice.model.request.BookingRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * GET
 * PUT
 * POST
 * DELETE
 * PATCH
 */
public interface FlightBookingController {

    public int getBookingId(int id);

    public ResponseEntity<String> createBooking(BookingRequest request);


    public ResponseEntity<String> updateBookingRequest(int id, BookingRequest request);

    public ResponseEntity<String> deleteBooking(int id);
}
