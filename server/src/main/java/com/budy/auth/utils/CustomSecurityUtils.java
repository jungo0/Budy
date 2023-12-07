package com.budy.auth.utils;

import com.budy.exception.BusinessLogicException;
import com.budy.exception.ExceptionCode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class CustomSecurityUtils {
    public static Long getMemberId() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Object principal = authentication.getPrincipal();
            return (Long) principal;
        }
        catch (ClassCastException e) {
            throw new BusinessLogicException(ExceptionCode.ACCESS_TOKEN_EXPIRED);
        }
    }
}
