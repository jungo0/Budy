package com.budy.route.controller;

import com.budy.route.dto.RouteCreateDto;
import com.budy.route.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
}
