package app.model.entity.barbershop;

import app.model.entity.barber.Barber;
import app.model.entity.hairservice.HairService;
import app.model.entity.workingday.WorkingDay;
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
@Table(name="barbershop")
public class Barbershop {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String address;
    private String phone;
    @Column(unique = true)
    private String email;
    @OneToMany(mappedBy = "barbershop")
    private List<Barber> barbers;
    @OneToMany(mappedBy = "barbershop")
    private List<HairService> services;
    @OneToMany(mappedBy = "barbershop")
    private List<WorkingDay> workingDays;
}
