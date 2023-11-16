package com.budy.auth.handler;

import com.budy.auth.jwt.JwtTokenizer;
import com.budy.auth.utils.CustomAuthorityUtils;
import com.budy.member.entity.Member;
import com.budy.member.repository.MemberRepository;
import com.budy.member.service.MemberService;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

public class MemberAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtTokenizer jwtTokenizer;
    private final CustomAuthorityUtils customAuthorityUtils;
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public MemberAuthenticationSuccessHandler(JwtTokenizer jwtTokenizer,
        CustomAuthorityUtils customAuthorityUtils, MemberService memberService,
        MemberRepository memberRepository) {
        this.jwtTokenizer = jwtTokenizer;
        this.customAuthorityUtils = customAuthorityUtils;
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        var oAuth2User = (OAuth2User)authentication.getPrincipal();
        String memberEmail = String.valueOf(oAuth2User.getAttributes().get("email"));
        System.out.println("log:" + memberEmail);

        if (memberRepository.findByMemberEmail(memberEmail) == null) {
            Member member =  new Member();
            String memberName = String.valueOf(oAuth2User.getAttributes().get("name"));
            member.setMemberEmail(memberEmail);
            member.setMemberName(memberName);

            Member createMember = memberService.createMember(member);

            List<String> authorities = customAuthorityUtils.createRoles(memberEmail);

            redirect(request, response, createMember, authorities);
        } else {
            Member member = memberRepository.findByMemberEmail(memberEmail);
            List<String> authorities = customAuthorityUtils.createRoles(memberEmail);

            redirect(request, response, member, authorities);
        }
    }


    private void redirect(HttpServletRequest request, HttpServletResponse response, Member member, List<String> authorities) throws IOException {
        String accessToken = jwtTokenizer.delegateAccessToken(member);
        String refreshToken = jwtTokenizer.delegateRefreshToken(member);

        String uri = createURI(accessToken, refreshToken).toString();
        getRedirectStrategy().sendRedirect(request, response, uri);
    }

    private URI createURI(String accessToken, String refreshToken) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("access_token", accessToken);
        queryParams.add("refresh_token", refreshToken);

        return UriComponentsBuilder
            .newInstance()
            .scheme("http")
            .host("localhost")
            .path("/receive-token.html")
            .queryParams(queryParams)
            .build()
            .toUri();
    }
}
