package org.faeriefit.microusers.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.faeriefit.microusers.dto.SignInAuthDTO;
import org.faeriefit.microusers.dto.SignUpAuthDTO;
import org.faeriefit.microusers.dto.tokens.JwtAuthResponse;
import org.faeriefit.microusers.service.AuthService;
import org.faeriefit.microusers.service.impl.AuthServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Auth",description = "api for user registration and authorization")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public JwtAuthResponse signup(@RequestBody @Valid SignUpAuthDTO authDTO, HttpServletResponse response){
        return authService.signup(authDTO,response);
    }

    @PostMapping("/login")
    public JwtAuthResponse login(@RequestBody @Valid SignInAuthDTO signInAuthDTO, @NonNull HttpServletResponse response){
        return authService.login(signInAuthDTO,response);
    }
}
