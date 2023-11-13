package com.budy.route.entity;

import com.budy.audit.Auditable;
import com.budy.member.entity.Member;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Route extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id", nullable = false, unique = true)
    private Long routeId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "route_title", nullable = false)
    private String routeTitle;

    @Column(name = "route_image")
    private String routeImage;

//    @Column(name = "route_type")
//    @Enumerated(EnumType.STRING)
//    private RouteType routeType;

    @Column(name = "route_itinerary")
    @Enumerated(EnumType.STRING)
    private RouteItinerary routeItinerary;

    @Column(name = "route_status")
    @Enumerated(EnumType.STRING)
    private RouteStatus routeStatus;

    @Column(name = "route_vehicle")
    @Enumerated(EnumType.STRING)
    private RouteVehicle routeVehicle;

    @Column(name = "route_origin", nullable = false)
    private String routeOrigin;

    @Column(name = "route_origin_latitude", nullable = false)
    private Double routeOriginLatitude;

    @Column(name = "route_origin_longitude", nullable = false)
    private Double routeOriginLongitude;

    @Column(name = "route_origin_departure_datetime", nullable = false)
    private LocalDateTime routeOriginDepartureDateTime;

    @Column(name = "route_destination", nullable = false)
    private String routeDestination;

    @Column(name = "route_destination_latitude", nullable = false)
    private Double routeDestinationLatitude;

    @Column(name = "route_destination_longitude", nullable = false)
    private Double routeDestinationLongitude;

    @Column(name = "route_origin_departure_time")
    private LocalDateTime routeDestinationDepartureDateTime;

    @Column(name = "route_cost", nullable = false)
    private Integer routeCost;

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<RouteOrigin> routeOriginList = new ArrayList<>();

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<RouteTag> routeTagList = new ArrayList<>();

//    public enum RouteType {
//        SINGLE,
//        REGULAR
//    }

    public enum RouteItinerary {
        ONE,
        ROUND
    }

    public enum RouteStatus {
        INCOMPLETE,
        COMPLETE
    }

    public enum RouteVehicle {
        SEATER_12,
        SEATER_44,
        SEATER_60
    }
}
