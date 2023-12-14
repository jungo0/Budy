package com.budy.route.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RouteInfoDto {
    private long routeId;
    private String routeTitle;
}
