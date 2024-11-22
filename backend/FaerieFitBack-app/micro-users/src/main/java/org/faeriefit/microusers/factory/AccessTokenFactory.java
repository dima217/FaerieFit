package org.faeriefit.microusers.factory;

import lombok.RequiredArgsConstructor;
import org.faeriefit.microentity.entity.user.Token;
import org.faeriefit.microusers.service.impl.JwtService;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
@RequiredArgsConstructor
public class AccessTokenFactory implements Function<Token,String> {
    private final JwtService jwtService;
    @Override
    public String apply(Token refreshToken) {
        return jwtService.GenerateToken(refreshToken);
    }

}
