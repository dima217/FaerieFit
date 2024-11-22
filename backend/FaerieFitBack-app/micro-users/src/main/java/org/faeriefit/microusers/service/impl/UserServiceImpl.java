package org.faeriefit.microusers.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.faeriefit.microentity.entity.user.User;
import org.faeriefit.microusers.convertor.UserDTOConvertor;
import org.faeriefit.microusers.dto.UserDTO;
import org.faeriefit.microusers.repository.UserRepository;
import org.faeriefit.microusers.service.UserService;
import org.faeriefit.microutility.exception.ExistResourceException;
import org.faeriefit.microutility.exception.NotResourceException;
import org.springframework.cache.annotation.Cacheable;
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
        return repository.findAll();
    }

    @Override
    @Cacheable(value = "users", key = "#id", unless = "#result == null")
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User save(UserDTO userDTO) {
        if (repository.existsByUsername(userDTO.getUsername())) {
            throw new ExistResourceException("Username exists!");
        }
        if (repository.existsByEmail(userDTO.getEmail())) {
            throw new ExistResourceException("Email exists!");
        }
        return repository.save(convertor.convertDTOToEntity(userDTO));
    }

    @Override
    public User update(UserDTO userUpdateDTO) {
        if (!repository.existsById(userUpdateDTO.getId())) {
            throw new NotResourceException("User does not exist");
        }
        return repository.save(convertor.convertDTOToEntity(userUpdateDTO));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new NotResourceException("User does not exist!");
        }
        repository.deleteById(id);
    }

    @Override
    public void deleteByEmail(String email) {
        if (!repository.existsByEmail(email)) {
            throw new NotResourceException("User does not exist!");
        }
        repository.deleteByEmail(email);
    }

    @Override
    public boolean existByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public boolean existById(Long id) {
        return repository.existsById(id);
    }
}
