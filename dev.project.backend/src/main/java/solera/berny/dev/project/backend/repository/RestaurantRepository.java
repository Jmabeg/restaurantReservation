package solera.berny.dev.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solera.berny.dev.project.backend.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
