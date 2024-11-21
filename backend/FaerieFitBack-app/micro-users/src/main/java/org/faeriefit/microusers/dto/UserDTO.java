package org.faeriefit.microusers.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.faeriefit.microentity.entity.user.Role;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private Long id;
    @Size(min = 5, max = 50, message = "Length must be greater than 5")
    @NotBlank(message = "Name is empty")
    private String username;
    @Email
    @Size(min = 5,message = "Length must be greater than 5")
    @NotBlank(message = "Email is empty")
    private String email;
    @Size(min = 5,max = 255, message = "The line length must be between 5 and 255 characters")
    @NotBlank(message = "Password is empty")
    private String password;
    private List<Role> roles;
}