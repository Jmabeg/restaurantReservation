package solera.berny.dev.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import solera.berny.dev.project.backend.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
