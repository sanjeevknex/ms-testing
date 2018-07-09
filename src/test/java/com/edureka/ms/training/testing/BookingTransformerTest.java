package com.edureka.ms.training.testing;

import com.edureka.ms.training.testing.model.Booking;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookingTransformerTest {

    @Test
    public void testTransform(){
        Booking expectedBooking = Booking.builder()
                .fromPlace("BLR")
                .toPlace("NYC")
                .fromLongitude(1L)
                .toLongitude(2L)
                .fromLatitude(3L)
                .toLatitude(4L)
                .carCategory("Uber Pool")
                .build();

        BookingRequest bookingRequest = BookingRequest.builder()
                .fromPlace("BLR")
                .toPlace("NYC")
                .fromLongitude(1L)
                .toLongitude(2L)
                .fromLatitude(3L)
                .toLatitude(4L)
                .carCategory("Uber Pool")
                .build();

        Booking actualBooking = new BookingTransformer().transform(bookingRequest);

        Assertions.assertThat(expectedBooking).isEqualTo(actualBooking);



    }

}