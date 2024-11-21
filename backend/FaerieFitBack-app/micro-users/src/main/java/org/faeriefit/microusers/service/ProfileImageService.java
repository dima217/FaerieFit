package org.faeriefit.microusers.service;

import org.faeriefit.microentity.entity.user.ProfileImage;
import org.faeriefit.microusers.dto.ProfileImageDTO;

import java.util.List;
import java.util.UUID;

public interface ProfileImageService {

    List<ProfileImage> findAll();

    ProfileImage findById(UUID id);

    ProfileImage save(ProfileImageDTO profileImageDTO);

    ProfileImage update(ProfileImageDTO profileImageDTO);

    void deleteById(UUID uuid);

}
