package app.mapper.barbershop;

import app.model.dto.barbershop.BarbershopDto;
import app.model.dto.barbershop.BarbershopRegisterRequest;
import app.model.entity.barbershop.Barbershop;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BarbershopMapper {

    private final PasswordEncoder passwordEncoder;

    public BarbershopMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Barbershop toEntity(BarbershopRegisterRequest request) {
        if (request == null) {
            return null;
        }
        return Barbershop.builder()
                .name(request.getName())
                .owner(request.getOwner())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
    }

    public Barbershop toEntity(BarbershopDto dto) {
        if (dto == null) {
            return null;
        }
        return Barbershop.builder()
                .id(dto.getId())
                .name(dto.getName())
                .owner(dto.getOwner())
                .address(dto.getAddress())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .barbers(dto.getBarbers())
                .services(dto.getServices())
                .workingDays(dto.getWorkingDays())
                .build();
    }

    public BarbershopDto toDto(Barbershop entity) {
        if (entity == null) {
            return null;
        }
        return BarbershopDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .owner(entity.getOwner())
                .address(entity.getAddress())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .barbers(entity.getBarbers())
                .services(entity.getServices())
                .workingDays(entity.getWorkingDays())
                .build();
    }
}

