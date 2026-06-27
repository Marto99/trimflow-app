package app.repository.hairservice;

import app.model.entity.hairservice.HairService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HairServiceRepository extends JpaRepository<HairService, UUID> {
}
