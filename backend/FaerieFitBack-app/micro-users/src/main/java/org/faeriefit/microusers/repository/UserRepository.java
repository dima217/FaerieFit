package org.faeriefit.microusers.repository;

import jakarta.transaction.Transactional;
import org.faeriefit.microentity.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    void deleteByEmail(String email);
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String name);

    boolean existsByEmail(String email);

}
