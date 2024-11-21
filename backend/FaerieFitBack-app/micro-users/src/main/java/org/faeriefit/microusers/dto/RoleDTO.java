package org.faeriefit.microusers.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDTO {
    private Long id;

    @Size(min = 3,max = 50,message = "Min string length must be greater than 3 and less 51 symbols")
    @NotNull(message = "Role is empty")
    private String role;

}