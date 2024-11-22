package org.faeriefit.microusers.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.faeriefit.microentity.entity.user.Profile;
import org.faeriefit.microusers.convertor.ProfileDTOConvertor;
import org.faeriefit.microusers.dto.ProfileDTO;
import org.faeriefit.microusers.repository.ProfileRepository;
import org.faeriefit.microusers.service.ProfileService;
import org.faeriefit.microutility.exception.ExistResourceException;
import org.faeriefit.microutility.exception.NotResourceException;
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

        if (repository.existsByUser(profileDTO.getUser())) {
            throw new ExistResourceException("Profile has been created!");
        }
        Profile profile = convertor.convertDTOToEntity(profileDTO);
        return repository.save(profile);
    }

    @Override
    public Profile update(ProfileDTO profileDTO) {

        if (!repository.existsByUser(profileDTO.getUser())) {
            throw new NotResourceException("Profile does not exist!");
        }
        Profile profile = convertor.convertDTOToEntity(profileDTO);
        return repository.save(profile);
    }

    @Override
    public Optional<Profile> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    @Override
    public Optional<Profile> findByUser(Long userId, String email) {
        return repository.findByUserIdOrUserEmail(userId, email);
    }

    @Override
    public List<Profile> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(UUID uuid) {
        if (!repository.existsById(uuid)) {
            throw new NotResourceException("Profile does not exist!");
        }
        repository.deleteById(uuid);
    }

    @Override
    public void deleteByUser(Long userId, String email) {
        if (!repository.existsByUserIdOrUserEmail(userId, email)) {
            throw new NotResourceException("Profile does not exist");
        }
        repository.deleteByUserIdOrUserEmail(userId, email);
    }
}
