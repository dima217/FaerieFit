package org.faeriefit.microusers.service;

import org.faeriefit.microentity.entity.user.Profile;
import org.faeriefit.microusers.dto.ProfileDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProfileService {
    Profile save (ProfileDTO profileDTO);

    Profile update(ProfileDTO profileDTO);

    Optional<Profile> findById(UUID uuid);

    Optional<Profile> findByUser(Long userId,String email);

    List<Profile> findAll();

    void deleteById(UUID uuid);

    void deleteByUser(Long userId,String email);
}