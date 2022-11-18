package com.myflight.book.bookingservice.controller;

import com.myflight.book.bookingservice.model.request.BookingRequest;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface FlightBookingController {

    public int getBookingId(int id);

    public String createBooking(BookingRequest request);


    String updateBookingRequest(int id, BookingRequest request);
}
