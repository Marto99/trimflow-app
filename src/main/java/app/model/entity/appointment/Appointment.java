package app.model.entity.appointment;

import app.model.entity.barber.Barber;
import app.model.entity.barbershop.Barbershop;
import app.model.entity.customer.Customer;
import app.model.entity.hairservice.HairService;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate appointmentDate;
    private LocalTime startTime;
    private LocalTime endTime;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status = AppointmentStatus.PENDING;
    private String notes;
    @ManyToOne
    @JoinColumn(name = "barbershop_id")
    private Barbershop barbershop;
    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barber;
    @ManyToOne
    @JoinColumn(name = "hair_service_id")
    private HairService hairService;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
