package com.budy.auth.utils;

import com.budy.auth.jwt.JwtTokenizer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthorityUtils {

    private final JwtTokenizer jwtTokenizer;

    @Value("${mail.address.admin}")
    private String adminMailAddress;

    private final List<GrantedAuthority> ADMIN_ROLES = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
    private final List<GrantedAuthority> USER_ROLES = AuthorityUtils.createAuthorityList("ROLE_USER");
    private final List<String> ADMIN_ROLES_STRING = List.of("ADMIN");
    private final List<String> USER_ROLES_STRING = List.of("USER");


    public CustomAuthorityUtils(JwtTokenizer jwtTokenizer) {
        this.jwtTokenizer = jwtTokenizer;
    }

    public String replaceBearer(HttpServletRequest request) {
        String accessToken = request.getHeader("Authorization").replace("Bearer ", "");

        return accessToken;
    }

    public Jws<Claims> verifyJws(HttpServletRequest request) {
        String jws = replaceBearer(request);
        String base64EncodedSecretKey = jwtTokenizer.encodeBase64SecretKey(jwtTokenizer.getSecretKey());
        Jws<Claims> claims = jwtTokenizer.getClaims(jws, base64EncodedSecretKey);
        return claims;
    }

    public List<GrantedAuthority> createAuthorities(String email) {
        if (email.equals(adminMailAddress)) {
            return ADMIN_ROLES;
        }
        return USER_ROLES;
    }

    public List<GrantedAuthority> createAuthorities(Object memberRole) {
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + memberRole);
        List<GrantedAuthority> authorities = Collections.singletonList(authority);
        return authorities;
    }

    public List<String> createRoles(String email) {
        if (email.equals(adminMailAddress)) {
            return ADMIN_ROLES_STRING;
        }
        return USER_ROLES_STRING;
    }
}
