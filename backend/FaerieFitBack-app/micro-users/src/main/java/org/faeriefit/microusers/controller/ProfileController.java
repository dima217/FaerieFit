package org.faeriefit.microusers.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.faeriefit.microentity.entity.user.Profile;
import org.faeriefit.microusers.dto.ProfileDTO;
import org.faeriefit.microusers.dto.ProfileSearchDTO;
import org.faeriefit.microusers.service.ProfileService;
import org.faeriefit.microutility.exception.NotResourceException;
import org.faeriefit.microutility.exception.NotValidateParamException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService service;

    @PostMapping("/id")
    ResponseEntity<Profile> findById(@RequestBody UUID id) {
        Optional<Profile> profile = service.findById(id);
        if (profile.isEmpty()) {
            throw new NotResourceException("Profile does not exist");
        }
        return ResponseEntity.ok(profile.get());
    }

    @PostMapping("/user")
    public ResponseEntity<Profile> findByUser(@Valid @RequestBody ProfileSearchDTO profileSearchDTO){
        String email = profileSearchDTO.getEmail();
        Long userId = profileSearchDTO.getUserId();

        if(!email.trim().isEmpty() && userId <= 0){
            throw new NotValidateParamException("Param missed: userId");
        }

        if(email.isEmpty() && userId >0 ){
            throw new NotValidateParamException("Param missed: email");
        }

        Optional<Profile> profile = service.findByUser(userId, email);

        if(profile.isEmpty()){
            throw new NotResourceException("profile is not exist");
        }
        return ResponseEntity.ok(profile.get());

    }

    @PutMapping("/update")
    ResponseEntity<Profile> update(@RequestBody @Valid ProfileDTO profileDTO) {
        return ResponseEntity.ok(service.update(profileDTO));
    }

}
