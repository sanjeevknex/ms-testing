package com.edureka.ms.training.testing;

import com.edureka.ms.training.testing.model.Booking;
import com.edureka.ms.training.testing.respository.BookingCommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class BookingService {

    @Autowired
    BookingCommandRepository repository;

    public Booking saveBooking(@NotNull Booking booking) {
        return repository.save(booking);
    }

}
