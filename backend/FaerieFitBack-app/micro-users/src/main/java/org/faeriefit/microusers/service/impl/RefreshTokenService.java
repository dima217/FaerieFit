package org.faeriefit.microusers.service.impl;

import lombok.RequiredArgsConstructor;
import org.faeriefit.microentity.entity.user.Token;
import org.faeriefit.microusers.repository.TokenRepository;
import org.faeriefit.microutility.exception.NotResourceException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
    private final TokenRepository tokenRepository;
    private final Function<Authentication, Token> tokenFactory;

    public Optional<Token> findByTokenId(String tokenId){
        return tokenRepository.findByToken(tokenId);
    }

    public void deleteToken(Integer id){
        var refreshToken = tokenRepository.findById(id);

        if(refreshToken.isEmpty()){
            throw new NotResourceException("token is not exist");
        }

        tokenRepository.deleteById(refreshToken.get().getId());
    }

    public Token createRefreshToken(Authentication authentication){
            Optional<Token> optionalToken = findByToken(authentication);
            Token token = tokenFactory.apply(authentication);

                if (optionalToken.isPresent()) {
                    try {
                        return verifyException(optionalToken.get());
                    }
                    catch (RuntimeException runtimeException){
                        return tokenRepository.save(token);
                    }
                } else {
                    return tokenRepository.save(token);
                }


    }

    public Optional<Token> findByToken(Authentication authentication){
        return tokenRepository.findByUsername(authentication.getName());
    }

    public Token verifyException(Token token){
        if(token.getExpiryDate().compareTo(Instant.now()) < 0){
            deleteToken(token.getId());
            throw new RuntimeException(token.getToken() + " Refresh token is expired. Please make a new login..!");
        }
        return token;
    }



}
