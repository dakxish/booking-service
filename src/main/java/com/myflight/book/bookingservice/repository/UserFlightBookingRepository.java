package com.myflight.book.bookingservice.repository;

import com.myflight.book.bookingservice.model.schema.UserFlightBookingRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserFlightBookingRepository extends MongoRepository<UserFlightBookingRecord, String> {
}
