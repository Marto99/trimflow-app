package app.model.dto.barbershop;

import app.model.entity.barber.Barber;
import app.model.entity.hairservice.HairService;
import app.model.entity.workingday.WorkingDay;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class BarbershopDto {
    private UUID id;
    private String name;
    private String owner;
    private String address;
    private String phone;
    private String email;
    private String password;
    private List<Barber> barbers;
    private List<HairService> services;
    private List<WorkingDay> workingDays;
}
