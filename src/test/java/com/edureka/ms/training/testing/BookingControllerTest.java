package com.edureka.ms.training.testing;

import com.edureka.ms.training.testing.model.Booking;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @InterfaceTest
    public void testInterfaceWithDummyRequest() throws Exception {
        BookingRequest bookingRequest = BookingRequest.builder()
                .carCategory("Uber Pool")
                .fromLatitude(1L)
                .fromLongitude(1L)
                .toLatitude(-1L)
                .toLongitude(2L)
                .fromPlace("BLR")
                .toPlace("NYC")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String bookingAsJSONString = objectMapper.writeValueAsString(bookingRequest);

        this.mockMvc
                .perform(
                        post("/booking")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(bookingAsJSONString)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().string(bookingAsJSONString))
                .andExpect(status().is2xxSuccessful());


    }

    @Test
    public void testBookingCreated() throws Exception {
        BookingRequest bookingRequest = BookingRequest.builder()
                .carCategory("Uber Pool")
                .fromLatitude(1L)
                .fromLongitude(2L)
                .toLatitude(3L)
                .toLongitude(4L)
                .fromPlace("BLR")
                .toPlace("NYC")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String bookingAsJSONString = objectMapper.writeValueAsString(bookingRequest);

        Booking savedEntity = new BookingTransformer().transform(bookingRequest);
        savedEntity.setId(1L); //FIXME

        String savedEntityJSON = objectMapper.writeValueAsString(savedEntity);

        this.mockMvc
                .perform(
                        post("/booking")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(bookingAsJSONString)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().string(savedEntityJSON))
                .andExpect(status().is2xxSuccessful());


    }


}