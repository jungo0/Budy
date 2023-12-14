package com.budy.route.dto;

import com.budy.dto.PageInfoDto;
import com.budy.route.entity.Route;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
@Builder
public class RouteInfoPageDto {
    List<RouteInfoDto> routeInfoList;
    PageInfoDto pageInfo;
}
