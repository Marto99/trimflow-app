package app.model.dto.barbershop;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BarbershopLoginRequest {
    @Email
    @Column(unique = true)
    private String email;
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    private String password;
}
