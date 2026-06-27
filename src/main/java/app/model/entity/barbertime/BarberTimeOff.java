package app.model.entity.barbertime;

import app.model.entity.barber.Barber;
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
@Table(name="barber_time_offs")
public class BarberTimeOff {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String reason;
    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barber;
}
