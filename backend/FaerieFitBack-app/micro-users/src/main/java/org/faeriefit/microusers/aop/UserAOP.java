package org.faeriefit.microusers.aop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.faeriefit.microentity.entity.user.User;
import org.faeriefit.microusers.dto.ProfileDTO;
import org.faeriefit.microusers.service.ProfileService;
import org.faeriefit.microusers.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class UserAOP {
    private final UserService userService;
    private final ProfileService profileService;

    @AfterReturning(value = "execution(* org.faeriefit.microusers.service.UserService.save(*))", returning = "saveUser")
    public void createProfileToUser(User saveUser) {
        Optional<User> findUser = userService.findById(saveUser.getId());

        findUser.ifPresent(user -> {
            profileService.save(ProfileDTO.builder()
                    .user(user)
                    .build());
        });
    }
}
