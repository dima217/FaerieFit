package org.faeriefit.microusers.repository;

import com.google.common.base.Optional;
import org.faeriefit.microentity.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(String role);
}
