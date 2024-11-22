package org.faeriefit.microusers.service.tokens.impl;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.faeriefit.microentity.entity.user.Token;
import org.faeriefit.microusers.service.impl.RefreshTokenService;
import org.faeriefit.microusers.service.tokens.AccessTokenService;
import org.faeriefit.microutility.exception.NotResourceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;


@Service
@Slf4j
@RequiredArgsConstructor
public class AccessTokenServiceImpl implements AccessTokenService {
    private final RefreshTokenService refreshTokenService;
    private final Function<Token,String> accessTokeFactory;

    @Override
    public String update(String tokenId, HttpServletResponse response) {
        log.info("refreshToken:{}",tokenId);
        Optional<Token> token = refreshTokenService.findByTokenId(tokenId);

        if(token.isEmpty()) throw new NotResourceException("token is not exist");
        refreshTokenService.verifyException(token.get());


        var accessToken = accessTokeFactory.apply(token.get());
        ResponseCookie cookie = ResponseCookie.from("accessToken")
                .value(accessToken)
                .secure(true)
                .httpOnly(true)
                .path("/")
                .build();
        response.addHeader(HttpHeaders.SET_COOKIE,cookie.toString());

        return accessToken;
    }
}
