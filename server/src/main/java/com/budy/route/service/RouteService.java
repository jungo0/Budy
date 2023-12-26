package com.budy.route.service;

import com.budy.route.dto.RouteCreateDto;
import com.budy.route.dto.RouteDetailsDto;
import com.budy.route.dto.RouteInfoPageDto;

public interface RouteService {

    void createRoute(RouteCreateDto routeCreateDto);
    RouteInfoPageDto getRouteList(int page);
    RouteDetailsDto getRouteDetails(long routeId);
    void deleteRoute(long routeId);
}
