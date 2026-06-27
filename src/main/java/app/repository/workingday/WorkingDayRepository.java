package app.repository.workingday;

import app.model.entity.workingday.WorkingDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkingDayRepository extends JpaRepository<WorkingDay, UUID> {
}
