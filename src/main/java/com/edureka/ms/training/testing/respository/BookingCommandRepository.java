package com.edureka.ms.training.testing.respository;

import com.edureka.ms.training.testing.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.OperationNotSupportedException;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface BookingCommandRepository extends JpaRepository<Booking, Long> {

    //select * from booking where place = :place
    Optional<Booking> findByFromPlace(String fromPlace);

    default void save2(Booking booking){
        throw new RuntimeException("Operation Not supported");
    }

}
