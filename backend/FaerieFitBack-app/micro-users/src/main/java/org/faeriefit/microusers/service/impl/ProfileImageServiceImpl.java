package org.faeriefit.microusers.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.faeriefit.microentity.entity.user.Profile;
import org.faeriefit.microentity.entity.user.ProfileImage;
import org.faeriefit.microusers.convertor.ProfileDTOConvertor;
import org.faeriefit.microusers.convertor.ProfileImageDTOConvertor;
import org.faeriefit.microusers.dto.ProfileImageDTO;
import org.faeriefit.microusers.repository.ProfileImageRepository;
import org.faeriefit.microusers.service.ProfileImageService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class ProfileImageServiceImpl implements ProfileImageService {

    private final ProfileImageDTOConvertor convertor;
    private final ProfileImageRepository repository;

    @Override
    public List<ProfileImage> findAll() {
        return repository.findAll();
    }

    @Override
    public ProfileImage findById(UUID id) {
        return null;
    }

    @Override
    public ProfileImage save(ProfileImageDTO profileImageDTO) {
        return null;
    }

    @Override
    public ProfileImage update(ProfileImageDTO profileImageDTO) {
        return null;
    }

    @Override
    public void deleteById(UUID uuid) {

    }
}
