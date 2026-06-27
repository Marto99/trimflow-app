package app.model.entity.customer;

import app.model.entity.appointment.Appointment;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String fullName;
    private String phone;
    private String email;
    @OneToMany(mappedBy = "customer")
    private List<Appointment> appointments;
}
