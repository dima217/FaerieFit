package org.faeriefit.microusers.service.impl;

import lombok.RequiredArgsConstructor;
import org.faeriefit.microentity.entity.user.Role;
import org.faeriefit.microentity.entity.user.User;
import org.faeriefit.microusers.dto.UserDTO;
import org.faeriefit.microusers.service.RoleService;
import org.faeriefit.microusers.service.UserAuthService;
import org.faeriefit.microusers.service.UserService;
import org.faeriefit.microutility.exception.NotResourceException;
import org.faeriefit.microutility.service.ConvertorDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {
    private final UserService userService;
    private final RoleService roleService;
    private final ConvertorDTO<UserDTO, User> userConvertorDTO;

    @Override
    public User authUser(User user) {
        Optional<Role> role = roleService.findByRole("USER");

        if(role.isEmpty()) throw new NotResourceException("service not create role");

        user.setRoles(List.of(role.get()));
        return userService.save(userConvertorDTO.convertEntityToDTO(user));
    }
}
