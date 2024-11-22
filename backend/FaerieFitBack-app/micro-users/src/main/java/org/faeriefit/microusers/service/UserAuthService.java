package org.faeriefit.microusers.service;

import org.faeriefit.microentity.entity.user.User;

public interface UserAuthService {
    User authUser(User user);
}
