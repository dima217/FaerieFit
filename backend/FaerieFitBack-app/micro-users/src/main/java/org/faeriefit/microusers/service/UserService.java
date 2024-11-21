package org.faeriefit.microusers.service;

import org.faeriefit.microentity.entity.user.User;
import org.faeriefit.microusers.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    Optional<User> findById(Long id);

    User save(UserDTO userDTO);

    User update(UserDTO userUpdateDTO);

    Optional<User> findByEmail(String email);

    List<User> findBySearch(String email,String password);

    void deleteById(Long id);

    void deleteByEmail(String email);


    Optional<User> findByUsername(String username);

    boolean existByUsername(String username);

    boolean existById(Long id);
}
