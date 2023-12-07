package com.budy.route.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RouteDestinationDepartureDateTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="route_destination_departure_date_time_id")
    private Long routeDestinationDepartureDateTimeId;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @ManyToOne
    @JoinColumn(name = "destination_departure_date_time_id")
    private DestinationDepartureDateTime destinationDepartureDateTime;
}
