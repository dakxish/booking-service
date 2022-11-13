package com.myflight.book.bookingservice.controller;

import com.myflight.book.bookingservice.model.request.BookingRequest;

public interface FlightBookingController {

    public int getBookingId(int id);

    public String createBooking(BookingRequest request);


}
