package com.myflight.book.bookingservice.service;

import com.myflight.book.bookingservice.model.request.BookingRequest;
import com.myflight.book.bookingservice.model.schema.UserFlightBookingRecord;
import com.myflight.book.bookingservice.repository.UserFlightBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private UserFlightBookingRepository repository;

    public UserFlightBookingRecord createBookingRecords(BookingRequest bookingRequest){

       UserFlightBookingRecord userFlightBookingRecord = UserFlightBookingRecord.builder()
                .sourceName(bookingRequest.getSourceName())
                .destinationName(bookingRequest.getDestinationName())
                .userName(bookingRequest.getUserName())
                .flightTime(bookingRequest.getFlightTime())
                .reservationTime(bookingRequest.getReservationTime())
                .build();

        return repository.insert(userFlightBookingRecord);
    }
}

