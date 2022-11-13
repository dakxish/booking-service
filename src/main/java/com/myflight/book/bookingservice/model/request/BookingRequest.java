package com.myflight.book.bookingservice.model.request;

import java.time.LocalDateTime;

public class BookingRequest {

    private String userName;
    private String sourceName;
    private String destinationName;
    private LocalDateTime flightTime;
    private LocalDateTime reservationTime;

    public BookingRequest(String userName, String sourceName, String destinationName, LocalDateTime flightTime, LocalDateTime reservationTime) {
        this.userName = userName;
        this.sourceName = sourceName;
        this.destinationName = destinationName;
        this.flightTime = flightTime;
        this.reservationTime = reservationTime;
    }

    public BookingRequest() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public LocalDateTime getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(LocalDateTime flightTime) {
        this.flightTime = flightTime;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }
}
