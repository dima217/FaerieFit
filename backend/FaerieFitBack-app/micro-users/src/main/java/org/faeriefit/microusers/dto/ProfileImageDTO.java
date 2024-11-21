package org.faeriefit.microusers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.faeriefit.microentity.entity.user.Profile;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileImageDTO {
    private UUID uuid;

    @Size(min = 3,message = "Min length 3 symbols")
    @NotBlank(message = "Src content is empty")
    @NotEmpty
    private String srcContent;
    @NotNull(message = "Profile is empty")
    private Profile profile;
}