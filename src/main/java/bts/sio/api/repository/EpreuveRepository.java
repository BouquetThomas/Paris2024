package bts.sio.api.repository;

import bts.sio.api.model.Athlete;
import bts.sio.api.model.Epreuve;
import bts.sio.api.model.Olympiade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpreuveRepository extends CrudRepository<Epreuve, Long> {
    List<Epreuve> findBySportId(Long sportId);
}
