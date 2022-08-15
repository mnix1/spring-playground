package com.example.exercise1starter;

import com.example.bootstarter.Role;
import com.example.bootstarter.RoleService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

class AuthorizationInterceptor implements HandlerInterceptor {
    private final RoleService roleService;

    AuthorizationInterceptor(RoleService roleService) {
        this.roleService = roleService;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        Optional<Role> role = roleService.findRole(token);
        if (role.isEmpty()) {
            response.setStatus(403);
            return false;
        }
        request.setAttribute("role", role.get());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}