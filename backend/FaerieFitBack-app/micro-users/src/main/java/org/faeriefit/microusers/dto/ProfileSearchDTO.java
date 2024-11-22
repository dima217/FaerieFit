package org.faeriefit.microusers.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileSearchDTO {
    private Long userId;
    @Email
    private String email;
}
