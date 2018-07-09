package com.edureka.ms.training.testing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {

    private Long id;

    private String carCategory;

    private Long fromLongitude;

    private Long fromLatitude;

    private Long toLongitude;

    private Long toLatitude;

    private String fromPlace;

    private String toPlace;
}
