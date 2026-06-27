package app.model.entity.workingday;

import app.model.entity.barbershop.Barbershop;
import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="workingdays")
public class WorkingDay {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private boolean working = true;
    @ManyToOne
    @JoinColumn(name = "barbershop_id")
    private Barbershop barbershop;

}
