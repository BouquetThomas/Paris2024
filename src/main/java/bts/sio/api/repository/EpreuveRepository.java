package bts.sio.api.repository;


import bts.sio.api.model.Epreuve;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpreuveRepository extends CrudRepository<Epreuve, Long> {
    List<Epreuve> findBySport_id(Long sport_id);
}
