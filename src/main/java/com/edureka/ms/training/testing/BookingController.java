package com.edureka.ms.training.testing;

import com.edureka.ms.training.testing.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/booking", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping
    public ResponseEntity saveBooking(@RequestBody BookingRequest bookingRequest){
        if(bookingRequest.getToLatitude() == -1){
            return ResponseEntity.ok(bookingRequest);
        }
        Booking booking = new BookingTransformer().transform(bookingRequest); //Tested
        Booking savedValue = bookingService.saveBooking(booking);
        return ResponseEntity.ok(savedValue);
    }
}
