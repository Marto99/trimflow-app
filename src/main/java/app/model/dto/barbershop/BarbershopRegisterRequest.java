package app.model.dto.barbershop;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BarbershopRegisterRequest {
    @Size(min = 2, message = "Barbershop name must be at lest 2 characters long.")
    @Column(unique = true)
    private String name;
    @Size(min = 2, message = "Name of the owner must be at least 2 characters long.")
    private String owner;
    @Email
    @Column(unique = true)
    private String email;
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    private String password;
}
