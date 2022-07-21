package web.brk.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import web.brk.models.AutomoveisModel;
import web.brk.repositories.AutomoveisRepository;

@Service
public class AutomoveisService {

    final AutomoveisRepository automoveisRepository;

    public AutomoveisService(AutomoveisRepository automoveisRepository) {
        this.automoveisRepository = automoveisRepository;
    }

    @Transactional
    public AutomoveisModel save(AutomoveisModel automoveisModel) {
        return automoveisRepository.save(automoveisModel);
    }

    public boolean existsByPlacaCarro(String placaCarro) {
        return automoveisRepository.existsByPlacaCarro(placaCarro);
    }

    public List<AutomoveisModel> findAll() {
        return automoveisRepository.findAll();
    }

}
