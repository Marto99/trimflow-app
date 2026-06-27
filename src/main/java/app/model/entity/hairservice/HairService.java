package app.model.entity.hairservice;

import app.model.entity.appointment.Appointment;
import app.model.entity.barber.Barber;
import app.model.entity.barbershop.Barbershop;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="services")
public class HairService {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer durationMinutes;
    private boolean active = true;
    @ManyToOne
    @JoinColumn(name = "barbershop_id")
    private Barbershop barbershop;
    @ManyToMany(mappedBy = "services")
    private List<Barber> barbers;
    @OneToMany(mappedBy = "hairService")
    private List<Appointment> appointments;
}
