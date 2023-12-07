package com.budy.route.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class RouteCreateDto {
    private String routeTitle;
    private String routeType;
    private String routeItinerary;
    private String routeVehicle;
    private String routeOrigin;
    private Double routeOriginLatitude;
    private Double routeOriginLongitude;
    private String routeDestination;
    private Double routeDestinationLatitude;
    private Double routeDestinationLongitude;
    private Integer routePrice;
//    private List<LocalDateTime> routeOriginDepartureDateTimeList;
//    private List<LocalDateTime> routeDestinationDepartureDateTimeList;
}
