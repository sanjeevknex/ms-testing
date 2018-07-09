package com.edureka.ms.training.testing.respository;

import com.edureka.ms.training.testing.model.Booking;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingRepositoryTest {

    @Autowired
    BookingCommandRepository bookingRepository;

    @Test
    public void testSave(){
        Booking booking = Booking.builder()
                .id(1L)
                .carCategory("Uber Pool")
                .fromLatitude(1L)
                .fromLongitude(1L)
                .toLatitude(2L)
                .toLongitude(2L)
                .fromPlace("BLR")
                .toPlace("NYC")
                .build();

        bookingRepository.save(booking);

        Optional<Booking> fromDBBooking = bookingRepository.findById(1L);

        Assertions.assertThat(fromDBBooking.get()).isNotNull();
        Assertions.assertThat(fromDBBooking.get()).isEqualTo(booking);

    }

    @Test
    public void testDelete(){
        Booking booking = Booking.builder()
                .id(2L)
                .carCategory("Uber Pool")
                .fromLatitude(1L)
                .fromLongitude(1L)
                .toLatitude(2L)
                .toLongitude(2L)
                .fromPlace("BLR")
                .toPlace("NYC")
                .build();

        bookingRepository.save(booking);
        bookingRepository.delete(booking);

        Optional<Booking> fromDBBooking = bookingRepository.findById(2L);

        Assertions.assertThat(fromDBBooking.isPresent()).isFalse();

    }

    @Test
    public void testBookingFindByFromCity(){
        Booking booking = Booking.builder()
                .id(1L)
                .carCategory("Uber Pool")
                .fromLatitude(1L)
                .fromLongitude(1L)
                .toLatitude(2L)
                .toLongitude(2L)
                .fromPlace("BLR2")
                .toPlace("NYC")
                .build();

        bookingRepository.save(booking);

        Optional<Booking> fromDBBooking = bookingRepository.findByFromPlace("BLR2");

        Assertions.assertThat(fromDBBooking.get()).isNotNull();
        Assertions.assertThat(fromDBBooking.get()).isEqualTo(booking);

    }

}