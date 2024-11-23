package org.faeriefit.microusers.controller;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.faeriefit.microentity.entity.user.User;
import org.faeriefit.microusers.dto.UserDTO;
import org.faeriefit.microusers.service.UserService;
import org.faeriefit.microutility.exception.NotResourceException;
import org.faeriefit.microutility.exception.NotValidateParamException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/id")
    ResponseEntity<User> findById(@RequestBody Long id) {
        Optional<User> user = service.findById(id);
        if (user.isEmpty()) {
            throw new NotResourceException("User does not exist!");
        }
        return ResponseEntity.ok(user.get());
    }

    @PostMapping("/email")
    ResponseEntity<User> findByEmail(@RequestBody String email) {
        if (StringUtils.isBlank(email)) {
            throw new NotValidateParamException("Email is null!");
        }

        Optional<User> user = service.findByEmail(email);

        if (user.isEmpty()) {
            throw new NotResourceException("User does not exist!");
        }

        return ResponseEntity.ok(user.get());
    }

    @PostMapping("/name")
    ResponseEntity<User> findByUsername(@RequestBody String username) {
        if (StringUtils.isBlank(username)) {
            throw new NotValidateParamException("Name is null!");
        }
        Optional<User> user = service.findByUsername(username);

        if (user.isEmpty()) {
            throw new NotResourceException("User does not exist!");
        }
        return ResponseEntity.ok(user.get());
    }

    @PostMapping("/add")
    ResponseEntity<User> save(@RequestBody UserDTO userDTO) {
        if (userDTO.getId() != null) {
            throw new NotValidateParamException("missed param:id");
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(userDTO));
    }

    @PutMapping("/update")
    ResponseEntity<User> update(@RequestBody UserDTO userDTO) {
        if (userDTO.getId() == null) {
            throw new NotValidateParamException("missed param: id");
        }
        return ResponseEntity.ok(service.update(userDTO));
    }

    @PutMapping("/delete/id")
    public void deleteById(@RequestBody Long id) {
        service.deleteById(id);
    }

    @PutMapping("/delete/email")
    public void deleteByEmail(@RequestBody String email) {
        service.deleteByEmail(email);
    }

    @PostMapping("/exist/id")
    ResponseEntity<Boolean> existById(@RequestBody Long id) {
        return ResponseEntity.ok(service.existById(id));
    }

    @PostMapping("/exist/id")
    ResponseEntity<Boolean> existByUsername(@RequestBody String username) {
        return ResponseEntity.ok(service.existByUsername(username));
    }

}


