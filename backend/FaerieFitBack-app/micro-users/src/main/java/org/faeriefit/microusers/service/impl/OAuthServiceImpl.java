package org.faeriefit.microusers.service.impl;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.faeriefit.microusers.service.OAuthService;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.Collections;

public class OAuthServiceImpl implements OAuthService {

    private final GoogleIdTokenVerifier tokenVerifier;

    public OAuthServiceImpl(@Value("${google.client-id}") String googleClientId) {
       var transport =  new NetHttpTransport();
       var factory = new GsonFactory();
       this.tokenVerifier = new GoogleIdTokenVerifier.Builder(transport, factory).
               setAudience(Collections.singletonList(googleClientId)).build();
    }
    @Override
    public void login(String googleToken) throws GeneralSecurityException, IOException {
        var token = tokenVerifier.verify(googleToken);

        var payload = token.getPayload();
    }
}
