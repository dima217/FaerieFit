package org.faeriefit.microusers.service;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface OAuthService {
    void login(String googleToken) throws GeneralSecurityException, IOException;
}
