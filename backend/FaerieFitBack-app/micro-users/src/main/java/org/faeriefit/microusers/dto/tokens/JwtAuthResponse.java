package org.faeriefit.microusers.dto.tokens;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/*
    JwtAuthResponse used when registering or
    authenticating a user
*/
@Data
@AllArgsConstructor
@Builder
public class JwtAuthResponse {
    private String accessToken;
    private String token;
}
