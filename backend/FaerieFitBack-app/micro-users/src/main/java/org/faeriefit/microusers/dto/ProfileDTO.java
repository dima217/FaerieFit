package org.faeriefit.microusers.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.faeriefit.microentity.entity.user.Genger;
import org.faeriefit.microentity.entity.user.User;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
public class ProfileDTO {

    @NotNull(message = "Uuid is empty")
    private UUID uuid;

    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Genger gender;

    private Double weight;

    private Double height;

    private Double hip_circumference;

    private Double chest_girth;

    private Double waist_circumference;

    private User user;
}