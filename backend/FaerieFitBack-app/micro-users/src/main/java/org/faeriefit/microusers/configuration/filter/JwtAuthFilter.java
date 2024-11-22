package org.faeriefit.microusers.configuration.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.faeriefit.microusers.service.impl.JwtService;
import org.faeriefit.microusers.service.impl.UserServiceDetailsImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;


@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserServiceDetailsImpl userServiceDetails;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        // Получаем токен из заголовка
        String username=null;
        String accessToken =null;
        String url = request.getRequestURI();

        if(request.getCookies() != null && !url.contains("/auth")){
            for(Cookie cookie : request.getCookies()){
                if(cookie.getName().equals("accessToken")){
                    accessToken = cookie.getValue();
                }
            }
        }

        if(accessToken == null){
            filterChain.doFilter(request,response);
            return;
        }

        username = jwtService.extractUsername(accessToken);

        if(username != null){
            //getting the user from the database
            UserDetails userDetails = userServiceDetails.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails.getUsername(),
                    userDetails.getPassword(),
                    userDetails.getAuthorities()

            );

            HashMap<String,String> param = new HashMap<>();
            param.put("username",userDetails.getUsername());

            // Проверка валидности токена
            if (jwtService.isTokenValid(accessToken,param)) {
                try {
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    //before checking the presence of a user in the context in UsernamePasswordAuthenticationFilter, we add it
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
                catch (AuthenticationException exception){
                    SecurityContextHolder.clearContext();
                }
            }


        }
        filterChain.doFilter(request,response);
    }
}
