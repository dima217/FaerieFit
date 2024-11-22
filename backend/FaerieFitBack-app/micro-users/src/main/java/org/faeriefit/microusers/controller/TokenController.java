package org.faeriefit.microusers.controller;


import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.faeriefit.microusers.dto.tokens.AccessTokenDTO;
import org.faeriefit.microusers.dto.tokens.TokenUpdateDTO;
import org.faeriefit.microusers.service.tokens.AccessTokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
@RequiredArgsConstructor
public class TokenController {
    private final AccessTokenService accessTokenService;
    @PostMapping("/access/update")
    public AccessTokenDTO accessTokenUpdate(@Valid @RequestBody TokenUpdateDTO dto, HttpServletResponse response){
        return AccessTokenDTO.builder()
                .token(accessTokenService.update(dto.getTokenRefresh(),response))
                .build();
    }
}
