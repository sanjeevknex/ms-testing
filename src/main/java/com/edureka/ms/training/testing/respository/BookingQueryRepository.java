package com.edureka.ms.training.testing.respository;

import com.edureka.ms.training.testing.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface BookingQueryRepository extends JpaRepository<Booking, Long> {
    public Optional<Booking> findById();
}
