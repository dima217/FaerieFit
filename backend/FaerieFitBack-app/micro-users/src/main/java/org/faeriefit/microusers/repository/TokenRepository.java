package org.faeriefit.microusers.repository;

import org.faeriefit.microentity.entity.user.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    Optional<Token> findByUsername(String username);

    Optional<Token> findByToken(String token);
}
