package app.repository.barbertime;

import app.model.entity.barbertime.BarberTimeOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BarberTimeOffRepository extends JpaRepository<BarberTimeOff, UUID> {
}
