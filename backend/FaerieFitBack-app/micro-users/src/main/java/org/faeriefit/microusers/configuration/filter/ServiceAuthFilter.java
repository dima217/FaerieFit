package org.faeriefit.microusers.configuration.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class ServiceAuthFilter extends OncePerRequestFilter {
    @Value("${service.key}")
    private String serviceKey;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("micro-service-key");

        //checking that this service is not third-party
        if(header !=null && header.equals(serviceKey)){
            var authenticationToken = new UsernamePasswordAuthenticationToken(
                    null,
                    null,
                    List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));

            //before checking the presence of a user in the context in UsernamePasswordAuthenticationFilter, we add it
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            filterChain.doFilter(request,response);
            return;
        }

        filterChain.doFilter(request,response);
    }
}
