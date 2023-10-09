package bts.sio.api.service;

import bts.sio.api.model.Ville;
import bts.sio.api.repository.VilleRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Data
@Service
    public class VilleService {
        @Autowired
        private VilleRepository villeRepository;

        public Optional<Ville> getVille(final Long id) {
            return villeRepository.findById(id);
        }

        public Iterable<Ville> getVilles() {
            return villeRepository.findAll();
        }

        public void deleteVille(final Long id) {
            villeRepository.deleteById(id);
        }

        public Ville saveVille(Ville ville) {
            Ville saveVille = villeRepository.save(ville);
            return saveVille;
        }
    }

