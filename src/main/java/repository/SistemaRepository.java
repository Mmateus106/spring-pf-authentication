package repository;

import entity.Sistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SistemaRepository extends JpaRepository<Sistema, Long> {
}
