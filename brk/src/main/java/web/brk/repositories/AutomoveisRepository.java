package web.brk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.brk.models.AutomoveisModel;

@Repository
public interface AutomoveisRepository extends JpaRepository<AutomoveisModel, Long>{

    boolean existsByPlacaCarro(String placaCarro);
    
}
