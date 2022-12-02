package com.myflight.book.bookingservice.model.schema;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("user_flight_booking_records")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserFlightBookingRecord {


    @Id
    private String  id;
    private String userName;
    private String sourceName;
    private String destinationName;
    private LocalDateTime flightTime;
    private LocalDateTime reservationTime;

    @Override
    public String toString() {
        return "UserFlightBookingRecord{" +
                "userName='" + userName + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", destinationName='" + destinationName + '\'' +
                ", flightTime=" + flightTime +
                ", reservationTime=" + reservationTime +
                '}';
    }
}
