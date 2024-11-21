package org.faeriefit.microutility.service;

import io.jsonwebtoken.Claims;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface JwtServiceBase {


     Date extractExpiry(String token);
     boolean isTokenExpired(String token);

    String extractUsername(String token);

    <T> T extractClaim(String token, Function<Claims,T> claimsResolve);


    Claims extractAllClaims(String token);

    String createToken(Map<String,Object> claims, String username);

    Key getSignKey();
}
