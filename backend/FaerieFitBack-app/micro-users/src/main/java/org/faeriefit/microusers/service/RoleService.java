package org.faeriefit.microusers.service;

import org.faeriefit.microentity.entity.user.Role;
import org.faeriefit.microusers.dto.RoleDTO;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> findAll();

    Role findById(Long id);

    Role save(RoleDTO roleDTO);

    Role update(RoleDTO roleDTO);

    void deleteById(Long id);

    Optional<Role> findByRole(String role);
}
