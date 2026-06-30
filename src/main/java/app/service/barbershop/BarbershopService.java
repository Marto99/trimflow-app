package app.service.barbershop;

import app.mapper.barbershop.BarbershopMapper;
import app.model.dto.barbershop.BarbershopDto;
import app.model.dto.barbershop.BarbershopRegisterRequest;
import app.model.entity.barbershop.Barbershop;
import app.repository.barbershop.BarbershopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarbershopService {

    private final BarbershopRepository barbershopRepository;
    private final BarbershopMapper barbershopMapper;

    @Autowired
    public BarbershopService(BarbershopRepository barbershopRepository, BarbershopMapper barbershopMapper) {
        this.barbershopRepository = barbershopRepository;
        this.barbershopMapper = barbershopMapper;
    }

    public BarbershopDto register(BarbershopRegisterRequest barbershopRegisterRequest) {
        barbershopRepository.findByName(barbershopRegisterRequest.getName()).ifPresent(barbershop -> {
            throw new RuntimeException("Barbershop with this name already exists!");
        });

        Barbershop barbershopEntity = barbershopMapper.toEntity(barbershopRegisterRequest);
        barbershopRepository.save(barbershopEntity);

        return barbershopMapper.toDto(barbershopEntity);
    }
}

