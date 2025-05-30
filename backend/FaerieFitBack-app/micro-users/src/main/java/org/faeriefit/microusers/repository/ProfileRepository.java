package org.faeriefit.microusers.repository;

import org.faeriefit.microentity.entity.user.Profile;
import org.faeriefit.microentity.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProfileRepository extends JpaRepository<Profile, UUID> {
    Optional<Profile> findByUserIdOrUserEmail(Long id, String email);

    void deleteByUserIdOrUserEmail(Long id, String email);

    boolean existsByUser(User user);

    boolean existsByUserIdOrUserEmail(Long userId,String email);
}
