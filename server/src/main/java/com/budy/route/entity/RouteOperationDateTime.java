package com.budy.route.entity;

import com.budy.origin.entity.Origin;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RouteOperationDateTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="route_operation_date_time_id")
    private Long routeOperationDateTimeId;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @ManyToOne
    @JoinColumn(name = "operation_date_time_id")
    private OperationDateTime operationDateTime;
}
