package com.budy.route.dto;

import com.budy.route.entity.Route.RouteStatus;
import com.budy.route.entity.Route.RouteType;
import com.budy.route.entity.Route.RouteVehicle;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RouteDetailsDto {

    private long routeId;
    private String routeTitle;
    private RouteType routeType;
    private RouteStatus routeStatus;
    private RouteVehicle routeVehicle;
    private String routeOrigin;
    private Double routeOriginLatitude;
    private Double routeOriginLongitude;
    private String routeDestination;
    private Double routeDestinationLatitude;
    private Double routeDestinationLongitude;
    private Integer routePrice;
    // originDepartureDateTime 추가
    // destinationDepartureDateTime 추가
    // List<OriginListDto> originListDtoList 추가
}
