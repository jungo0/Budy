package com.budy.route.mapper;

import com.budy.route.dto.RouteCreateDto;
import com.budy.route.entity.Route;
import com.budy.route.entity.Route.RouteItinerary;
import com.budy.route.entity.Route.RouteStatus;
import com.budy.route.entity.Route.RouteType;
import com.budy.route.entity.Route.RouteVehicle;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RouteMapper {

    default Route routeCreatetoRoute(RouteCreateDto routeCreateDto){
        Route route = new Route();
        route.setRouteTitle(routeCreateDto.getRouteTitle());
        route.setRouteType(RouteType.valueOf(routeCreateDto.getRouteType()));
        route.setRouteItinerary(RouteItinerary.valueOf(routeCreateDto.getRouteItinerary()));
        route.setRouteStatus(RouteStatus.INCOMPLETE);
        route.setRouteVehicle(RouteVehicle.valueOf(routeCreateDto.getRouteVehicle()));
        route.setRouteOrigin(routeCreateDto.getRouteOrigin());
        route.setRouteOriginLatitude(routeCreateDto.getRouteOriginLatitude());
        route.setRouteOriginLongitude(routeCreateDto.getRouteOriginLongitude());
        route.setRouteDestination(routeCreateDto.getRouteDestination());
        route.setRouteDestinationLatitude(routeCreateDto.getRouteDestinationLatitude());
        route.setRouteDestinationLongitude(routeCreateDto.getRouteDestinationLongitude());
        route.setRoutePrice(routeCreateDto.getRoutePrice());

        return route;
    }
}
