package com.edureka.ms.training.testing;

import com.edureka.ms.training.testing.model.Booking;
import com.edureka.ms.training.testing.respository.BookingCommandRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BookingServiceTest {


    BookingService bookingService;

    @Before
    public void beforeTest(){
        bookingService = new BookingService();
        bookingService.repository = Mockito.mock(BookingCommandRepository.class);
    }
    @Test
    public void shouldBookingSave(){
        Booking booking = Booking.builder().build();
        bookingService.saveBooking(booking);

        Mockito.verify(bookingService.repository).save(booking);
    }

    @Test
    public void shouldNotSaveBookingIfBookingIsNull(){
        Booking booking = null;
        bookingService.saveBooking(booking); //FIXME - Active Javax validation

        Mockito.verify(bookingService.repository).save(booking);
    }

}