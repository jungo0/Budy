package com.budy.route.entity;

import java.time.LocalDate;
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
public class OriginDepartureDateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "origin_departure_date_time_id", nullable = false, unique = true)
    private Long originDepartureDateTimeId;

    @Column(name = "origin_departure_date_time", nullable = false)
    private LocalDate originDepartureDateTime;

//    @Column(name = "origin_departure_date", nullable = false)
//    private LocalDate originDepartureDate;
//
//    @Column(name = "origin_departure_time", nullable = false)
//    private LocalTime originDepartureTime;

    @OneToMany(mappedBy = "originDepartureDateTime", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<RouteOriginDepartureDateTime> routeOriginDepartureDateTimeList = new ArrayList<>();
}