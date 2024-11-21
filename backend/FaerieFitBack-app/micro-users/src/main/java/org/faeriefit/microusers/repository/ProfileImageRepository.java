package org.faeriefit.microusers.repository;

import org.faeriefit.microentity.entity.user.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfileImageRepository extends JpaRepository<ProfileImage, UUID> {
    boolean existsBySrcContent(String srcContent);
}

