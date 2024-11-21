package org.faeriefit.microusers.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.faeriefit.microentity.entity.user.User;
import org.faeriefit.microusers.convertor.UserDTOConvertor;
import org.faeriefit.microusers.dto.UserDTO;
import org.faeriefit.microusers.repository.UserRepository;
import org.faeriefit.microusers.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDTOConvertor convertor;
    private final UserRepository repository;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(UserDTO userDTO) {
        return null;
    }

    @Override
    public User update(UserDTO userUpdateDTO) {
        return null;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<User> findBySearch(String email, String password) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteByEmail(String email) {

    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public boolean existByUsername(String username) {
        return false;
    }

    @Override
    public boolean existById(Long id) {
        return false;
    }
}
