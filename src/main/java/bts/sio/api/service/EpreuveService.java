package bts.sio.api.service;

import lombok.Data;
import bts.sio.api.model.Epreuve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bts.sio.api.repository.EpreuveRepository;

import java.util.List;
import java.util.Optional;
@Data
@Service
public class EpreuveService {
    @Autowired
    private EpreuveRepository epreuveRepository;

    public Optional<Epreuve> getEpreuve(final Long id) {
        return epreuveRepository.findById(id);
    }

    public Iterable<Epreuve> getEpreuves() {
        return epreuveRepository.findAll();
    }

    public void deleteEpreuve(final Long id) {
        epreuveRepository.deleteById(id);
    }

    public Epreuve saveEpreuve(Epreuve epreuve) {
        Epreuve saveEpreuve = epreuveRepository.save(epreuve);
        return saveEpreuve;
    }

    public List<Epreuve> getEpreuvesBySport_id(Long sport_id) {
        return epreuveRepository.findBySport_id(sport_id);
    }
}