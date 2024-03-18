package SpringBootProject.anformatic.repository;

import SpringBootProject.anformatic.model.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MasterRepository extends JpaRepository<Master,Long> {
    Optional<Master> findById(Long id);
}
