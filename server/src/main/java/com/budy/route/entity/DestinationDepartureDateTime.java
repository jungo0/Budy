package com.budy.route.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DestinationDepartureDateTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "destination_departure_date_time_id", nullable = false, unique = true)
    private Long destinationDepartureDateTimeId;

    @Column(name = "destination_departure_date_time", nullable = false)
    private LocalDateTime destinationDepartureDateTime;

//    @Column(name = "destination_departure_date", nullable = false)
//    private LocalDate destinationDepartureDate;
//
//    @Column(name = "destination_departure_time", nullable = false)
//    private LocalTime destinationDepartureTime;

    @OneToMany(mappedBy = "destinationDepartureDateTime", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<RouteDestinationDepartureDateTime> routeDestinationDepartureDateTimeList = new ArrayList<>();
}
