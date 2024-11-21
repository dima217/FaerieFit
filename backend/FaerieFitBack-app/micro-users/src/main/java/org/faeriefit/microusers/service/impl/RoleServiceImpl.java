package org.faeriefit.microusers.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.faeriefit.microentity.entity.user.Role;
import org.faeriefit.microusers.convertor.RoleDTOConvertor;
import org.faeriefit.microusers.dto.RoleDTO;
import org.faeriefit.microusers.repository.RoleRepository;
import org.faeriefit.microusers.service.RoleService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleDTOConvertor convertor;
    private final RoleRepository repository;

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Role findById(Long id) {
        return null;
    }

    @Override
    public Role save(RoleDTO roleDTO) {
        return null;
    }

    @Override
    public Role update(RoleDTO roleDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Role> findByRole(String role) {
        return Optional.empty();
    }
}
