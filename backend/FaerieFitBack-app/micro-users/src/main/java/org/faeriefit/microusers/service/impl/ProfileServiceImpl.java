package org.faeriefit.microusers.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.faeriefit.microentity.entity.user.Profile;
import org.faeriefit.microusers.convertor.ProfileDTOConvertor;
import org.faeriefit.microusers.dto.ProfileDTO;
import org.faeriefit.microusers.repository.ProfileRepository;
import org.faeriefit.microusers.service.ProfileService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileDTOConvertor convertor;
    private final ProfileRepository repository;

    @Override
    public Profile save(ProfileDTO profileDTO) {
        return null;
    }

    @Override
    public Profile update(ProfileDTO profileDTO) {
        return null;
    }

    @Override
    public Optional<Profile> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Optional<Profile> findByUser(Long userId, String email) {
        return Optional.empty();
    }

    @Override
    public List<Profile> findAll() {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void deleteByUser(Long userId, String email) {

    }
}
