package com.budy.route.service;

import com.budy.auth.utils.CustomSecurityUtils;
import com.budy.member.entity.Member;
import com.budy.member.repository.MemberRepository;
import com.budy.route.dto.RouteCreateDto;
import com.budy.route.dto.RouteInfoDto;
import com.budy.route.dto.RouteInfoPageDto;
import com.budy.route.entity.Route;
import com.budy.route.mapper.RouteMapper;
import com.budy.route.repository.RouteRepository;
import com.budy.dto.PageInfoDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RouteServiceImpl implements RouteService {

    private final RouteMapper routeMapper;
    private final RouteRepository routeRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void createRoute(RouteCreateDto routeCreateDto) {
        Route route = routeMapper.routeCreatetoRoute(routeCreateDto);
//        long authenticatedMemberId = CustomSecurityUtils.getMemberId();
//        Member findMember = memberRepository.findByMemberId(authenticatedMemberId);
//        route.setMember(findMember);

        routeRepository.save(route);
    }

    @Override
    @Transactional(readOnly = true)
    public RouteInfoPageDto getRouteList(int page) {

        Pageable pageable = PageRequest.of(page - 1, 20);

        Page<Route> findRoutePage = routeRepository.findAll(pageable);

        List<RouteInfoDto> routeInfoList = findRoutePage.getContent().stream()
            .map(routeMapper::routeToRouteInfo)
            .collect(Collectors.toList());

        PageInfoDto pageInfoDto = routeMapper.routePageToPageInfo(findRoutePage);

        return RouteInfoPageDto.builder()
            .routeInfoList(routeInfoList)
            .pageInfo(pageInfoDto)
            .build();
    }

}
