package org.faeriefit.microusers.service;

import jakarta.servlet.http.HttpServletResponse;
import org.faeriefit.microusers.dto.SignInAuthDTO;
import org.faeriefit.microusers.dto.SignUpAuthDTO;
import org.faeriefit.microusers.dto.tokens.JwtAuthResponse;

public interface AuthService {
    JwtAuthResponse signup(SignUpAuthDTO dto, HttpServletResponse response);

    JwtAuthResponse login(SignInAuthDTO dto, HttpServletResponse response);
}
