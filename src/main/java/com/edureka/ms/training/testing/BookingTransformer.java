package com.edureka.ms.training.testing;

import com.edureka.ms.training.testing.model.Booking;

public class BookingTransformer {

    public Booking transform(BookingRequest bookingRequest) {
        return Booking.builder()
                .carCategory(bookingRequest.getCarCategory())
                .fromLatitude(bookingRequest.getFromLatitude())
                .toLatitude(bookingRequest.getToLatitude())
                .fromLongitude(bookingRequest.getFromLongitude())
                .toLongitude(bookingRequest.getToLongitude())
                .fromPlace(bookingRequest.getFromPlace())
                .toPlace(bookingRequest.getToPlace())
                .build();
    }
}
