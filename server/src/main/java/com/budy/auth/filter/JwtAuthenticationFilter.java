package com.budy.auth.filter;

import com.budy.auth.jwt.JwtTokenizer;
import com.budy.member.entity.Member;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final JwtTokenizer jwtTokenizer;

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
        HttpServletResponse response,
        FilterChain chain,
        Authentication authResult) {
        Member member = (Member) authResult.getPrincipal();

        String accessToken = jwtTokenizer.delegateAccessToken(member);

        response.setHeader("Authorization", "Bearer " + accessToken);
        response.addHeader("Set-Cookie", jwtTokenizer.createCookie(member).toString());
        response.addHeader("Member-Role", member.getMemberRole().toString());
    }
}
