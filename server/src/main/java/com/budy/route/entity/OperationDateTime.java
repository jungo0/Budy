package com.budy.route.entity;

import java.time.LocalDateTime;
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
public class OperationDateTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operation_date_time_id", nullable = false, unique = true)
    private Long operationDateTimeId;

    @Column(name = "operation_origin_departure_date_time", nullable = false)
    private LocalDateTime operationOriginDepartureDateTime;

    @Column(name = "operation_destination_departure_date_time")
    private LocalDateTime operationDestinationDepartureDateTime;

    @OneToMany(mappedBy = "operationDateTime", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<RouteOperationDateTime> routeOperationDateTimeList = new ArrayList<>();
}
