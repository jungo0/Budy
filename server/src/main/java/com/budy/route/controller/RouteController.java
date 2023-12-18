package com.budy.route.controller;

import com.budy.route.dto.RouteCreateDto;
import com.budy.route.dto.RouteDetailsDto;
import com.budy.route.dto.RouteInfoDto;
import com.budy.route.dto.RouteInfoPageDto;
import com.budy.route.service.RouteService;
import java.util.List;
import javax.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/route/create")
    public ResponseEntity createRoute(@RequestBody @Valid RouteCreateDto routeCreateDto) {
        routeService.createRoute(routeCreateDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/route")
    public ResponseEntity getRouteList( @RequestParam(required = false, defaultValue = "1") int page) {
        RouteInfoPageDto routeInfoPageDto = routeService.getRouteList(page);

        return new ResponseEntity<>(routeInfoPageDto, HttpStatus.OK);
    }

    @GetMapping("/route/{route-id}")
    public ResponseEntity getRouteDetails(@PathVariable("route-id") @Positive long routeId) {

        RouteDetailsDto routeDetailsDto = routeService.getRouteDetails(routeId);

        return new ResponseEntity<>(routeDetailsDto, HttpStatus.OK);
    }
}
