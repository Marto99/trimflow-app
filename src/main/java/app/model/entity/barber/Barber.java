package app.model.entity.barber;

import app.model.entity.appointment.Appointment;
import app.model.entity.barbershop.Barbershop;
import app.model.entity.hairservice.HairService;
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
@Table(name="barbers")
public class Barber {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String fullName;
    private String phone;
    private String imageUrl;
    private boolean active = true;
    @ManyToOne
    @JoinColumn(name="barbershop_id")
    private Barbershop barbershop;
    @ManyToMany
    @JoinTable(name="barber_services", joinColumns = @JoinColumn(name = "barber_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<HairService> services;
    @OneToMany(mappedBy = "barber")
    private List<Appointment> appointments;
}
