package bts.sio.api.repository;



import bts.sio.api.model.Sport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportRepository extends CrudRepository<Sport, Long> {
    List<Sport> findByOlympiade_id(Long olympiade_id);
}