package org.faeriefit.microusers.dto.tokens;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenUpdateDTO implements Serializable {
    @Size(min = 1,message = "token length greater than 0")
    @NotBlank(message = "token length is 0")
    private String tokenRefresh;
}
