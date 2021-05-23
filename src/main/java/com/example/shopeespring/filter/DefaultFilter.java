package com.example.shopeespring.filter;

import com.example.shopeespring.dto.InvalidTokenDto;
import com.example.shopeespring.helper.jwt._decode.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class DefaultFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Default filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = request.getHeader("token");

        try {
            Claims claims = JwtUtil.verifyToken(token);
            String role = (String) claims.get("role");
            String userId = (String) claims.get("userId");
            if (role.equals("ADMIN")) {
                System.out.println("userrrr" + userId);
                request.setAttribute("user_id", userId);
                System.out.println("zzz");
                filterChain.doFilter(request, response);
            }else{
                System.out.println("bug bug");
            }
        } catch (Exception e) {
            response.setStatus(401);
            response.setContentType("application/json");
            InvalidTokenDto invalidTokenDto = new InvalidTokenDto("Invalid token");
            OutputStream out = response.getOutputStream();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(out,invalidTokenDto);
            out.flush();
        }
    }

    @Override
    public void destroy() {
        System.out.println("Default filter destroy");
    }
}
