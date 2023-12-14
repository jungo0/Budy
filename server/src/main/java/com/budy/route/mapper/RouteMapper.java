package com.budy.route.mapper;

import com.budy.route.dto.RouteCreateDto;
import com.budy.route.dto.RouteInfoDto;
import com.budy.route.entity.Route;
import com.budy.route.entity.Route.RouteItinerary;
import com.budy.route.entity.Route.RouteStatus;
import com.budy.route.entity.Route.RouteType;
import com.budy.route.entity.Route.RouteVehicle;
import com.budy.dto.PageInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

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

    default RouteInfoDto routeToRouteInfo(Route route){
        return RouteInfoDto.builder()
            .routeId(route.getRouteId())
            .routeTitle(route.getRouteTitle())
            .build();
    }

    default PageInfoDto routePageToPageInfo(Page<Route> routePage){
        return PageInfoDto.builder()
            .page(routePage.getNumber())
            .size(routePage.getSize())
            .totalPage(routePage.getTotalPages())
            .totalElement(routePage.getTotalElements())
            .build();
    }
}
