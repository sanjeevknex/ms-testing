package com.edureka.ms.training.testing;

import com.edureka.ms.training.testing.respository.BookingCommandRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsTrainingTestingApplicationTests {


    @Autowired
    BookingCommandRepository bookingRepository;

    @Test
    public void contextLoads() {

        Assertions.assertThat(bookingRepository).isNotNull();

    }

}
