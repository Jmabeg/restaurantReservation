package solera.berny.dev.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solera.berny.dev.project.backend.model.Chef;

public interface ChefRepository extends JpaRepository<Chef, Long> {

}
