package com.budy.route.service;

import com.budy.auth.utils.CustomSecurityUtils;
import com.budy.member.entity.Member;
import com.budy.member.repository.MemberRepository;
import com.budy.route.dto.RouteCreateDto;
import com.budy.route.entity.Route;
import com.budy.route.mapper.RouteMapper;
import com.budy.route.repository.RouteRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RouteServiceImpl implements RouteService{

    private final RouteMapper routeMapper;
    private final RouteRepository routeRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void createRoute(RouteCreateDto routeCreateDto) {
        Route route = routeMapper.routeCreatetoRoute(routeCreateDto);
        long authenticatedMemberId = CustomSecurityUtils.getMemberId();
        Member findMember = memberRepository.findByMemberId(authenticatedMemberId);
        route.setMember(findMember);

        routeRepository.save(route);
    }
}
