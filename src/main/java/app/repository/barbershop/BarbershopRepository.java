package app.repository.barbershop;

import app.model.entity.barbershop.Barbershop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BarbershopRepository extends JpaRepository<Barbershop, UUID> {
    Optional<Barbershop> findByName(String name);
}
