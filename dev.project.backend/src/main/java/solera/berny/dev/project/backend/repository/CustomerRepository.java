package solera.berny.dev.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solera.berny.dev.project.backend.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
