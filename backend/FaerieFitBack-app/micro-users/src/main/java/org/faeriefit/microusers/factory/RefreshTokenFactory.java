package org.faeriefit.microusers.factory;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.faeriefit.microentity.entity.user.Token;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;
import java.util.function.Function;

@Scope("prototype")
@Component
@RequiredArgsConstructor
@Setter
public class RefreshTokenFactory implements Function<Authentication, Token> {
    @Value("${time.token.refresh}")
    private long tokenTime;
    @Override
    public Token apply(Authentication authentication) {
        var now = Instant.now();
        String token = UUID.randomUUID().toString();
        String password = (String)authentication.getCredentials();
        return Token.builder()
                .token(token)
                .username(authentication.getName())
                .password(password)
                .issuerDate(now)
                .expiryDate(now.plusSeconds(tokenTime))
                .build();
    }
}
