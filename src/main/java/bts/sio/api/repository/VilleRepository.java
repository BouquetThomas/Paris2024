package bts.sio.api.repository;

import bts.sio.api.model.Ville;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface VilleRepository extends CrudRepository<Ville, Long> {

    }

