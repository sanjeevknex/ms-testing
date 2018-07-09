package com.edureka.ms.training.testing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="trip_booking", catalog = "training")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "car_category")
    private String carCategory;

    @Column(name = "from_longitude")
    private Long fromLongitude;

    @Column(name = "from_latitude")
    private Long fromLatitude;

    @Column(name = "to_longitude")
    private Long toLongitude;

    @Column(name = "to_latitude")
    private Long toLatitude;

    @Column(name = "from_place")
    private String fromPlace;

    @Column(name = "to_place")
    private String toPlace;
}
