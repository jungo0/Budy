    package com.budy.auth.filter;

    import com.budy.auth.jwt.JwtTokenizer;
    import com.budy.auth.utils.CustomAuthorityUtils;
    import com.budy.exception.BusinessLogicException;
    import com.budy.exception.ExceptionCode;
    import io.jsonwebtoken.Claims;
    import io.jsonwebtoken.ExpiredJwtException;
    import io.jsonwebtoken.Jws;
    import io.jsonwebtoken.security.SignatureException;
    import java.io.IOException;
    import java.util.List;
    import javax.servlet.FilterChain;
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.security.core.Authentication;
    import org.springframework.security.core.GrantedAuthority;
    import org.springframework.security.core.context.SecurityContextHolder;
    import org.springframework.web.filter.OncePerRequestFilter;

    public class JwtVerificationFilter extends OncePerRequestFilter {

        private final JwtTokenizer jwtTokenizer;
        private final CustomAuthorityUtils customAuthorityUtils;

        public JwtVerificationFilter(JwtTokenizer jwtTokenizer,
            CustomAuthorityUtils customAuthorityUtils) {
            this.jwtTokenizer = jwtTokenizer;
            this.customAuthorityUtils = customAuthorityUtils;
        }

        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

            try {
                Jws<Claims> claims = customAuthorityUtils.verifyJws(request);
                setAuthenticationToContext(claims);
            } catch (SignatureException signatureException) {
                BusinessLogicException businessLogicException = new BusinessLogicException(
                    ExceptionCode.INVALID_ACCESS_TOKEN_STATE);
                request.setAttribute("exception", signatureException);
            } catch (ExpiredJwtException expiredJwtException) {
                BusinessLogicException businessLogicException = new BusinessLogicException(
                    ExceptionCode.ACCESS_TOKEN_EXPIRED);
                request.setAttribute("exception", expiredJwtException);
            } catch (Exception e) {
                request.setAttribute("exception", e);
            }

            filterChain.doFilter(request, response);
        }

        @Override
        protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
            String authorization = request.getHeader("Authorization");

            return authorization == null || !authorization.startsWith("Bearer");
        }

        private void setAuthenticationToContext(Jws<Claims> claims) {
            Long memberId = claims.getBody().get("memberId", Long.class);
            Object memberRole = claims.getBody().get("memberRole");
            List<GrantedAuthority> authorities = customAuthorityUtils.createAuthorities(memberRole);
            Authentication authentication = new UsernamePasswordAuthenticationToken(memberId, null,
                authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }
