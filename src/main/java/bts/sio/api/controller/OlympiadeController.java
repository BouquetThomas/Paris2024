package bts.sio.api.controller;

import bts.sio.api.model.Olympiade;

import bts.sio.api.service.OlympiadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public class OlympiadeController {
    @Autowired
    private OlympiadeService olympiadeService;
    /**
     * Read - Get one athlete
     * @param id The id of the Olympiade
     * @return An Epreuve object full filled
     */
    @GetMapping("/olympiade/{id}")
    public Olympiade getOlympiade(@PathVariable("id") final Long id) {
        Optional<Olympiade> olympiade = olympiadeService.getOlympiade(id);
        if(olympiade.isPresent()) {
            return olympiade.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all athletes
     * @return - An Iterable object of Athlete full filled
     */
    @GetMapping("/olympiades")
    public Iterable<Olympiade> getOlympiade() {
        return olympiadeService.getLesOlympiades()  ;
    }



}
