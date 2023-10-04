package bts.sio.api.controller;

import bts.sio.api.model.Epreuve;
import bts.sio.api.model.Epreuve;
import bts.sio.api.model.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bts.sio.api.service.EpreuveService;

import java.util.List;
import java.util.Optional;

@RestController
public class EpreuveController {

    @Autowired
    private EpreuveService epreuveService;

    /**
     * Create - Add a new athlete
     * @param epreuve An object athlete
     * @return The  object saved
     */
    @PostMapping("/epreuve")
    public Epreuve createEpreuve(@RequestBody Epreuve epreuve) {
        return epreuveService.saveEpreuve(epreuve);
    }


    /**
     * Read - Get one athlete
     * @param id The id of the Epreuve
     * @return An Epreuve object full filled
     */
    @GetMapping("/epreuve/{id}")
    public Epreuve getEpreuve(@PathVariable("id") final Long id) {
        Optional<Epreuve> sport = epreuveService.getEpreuve(id);
        if(sport.isPresent()) {
            return sport.get();
        } else {
            return null;
        }
    }

    @GetMapping("/epreuves/sport/{sportId}")
    public List<Epreuve> getEpreuvesBySport(@PathVariable("sportId") final Long sportId) {
        return epreuveService.getEpreuvesBySport(sportId);
    }

    /**
     * Read - Get all athletes
     * @return - An Iterable object of Athlete full filled
     */
    @GetMapping("/epreuves")
    public Iterable<Epreuve> getEpreuve() {
        return epreuveService.getEpreuves();
    }

    /**
     * Update - Update an existing athlete
     * @param id - The id of the athlete to update
     * @param epreuve - The Epreuve object updated
     * @return
     */
    @PutMapping("/epreuve/{id}")
    public Epreuve updateEpreuve(@PathVariable("id") final Long id, @RequestBody Epreuve epreuve) {
        Optional<Epreuve> e = epreuveService.getEpreuve(id);
        if(e.isPresent()) {
            Epreuve currentEpreuve = e.get();

            String libelle = epreuve.getLibelle();
            if(libelle != null) {
                currentEpreuve.setLibelle(libelle);
            }

            Sport sport_id = epreuve.getSport();
            if(sport_id != null) {
                currentEpreuve.setSport(sport_id);;
            }

            epreuveService.saveEpreuve(currentEpreuve);
            return currentEpreuve;
        } else {
            return null;
        }
    }


    /**
     * Delete - Delete an athlete
     * @param id - The id of the athlete to delete
     */
    @DeleteMapping("/epreuve/{id}")
    public void deleteEpreuve(@PathVariable("id") final Long id) {
        epreuveService.deleteEpreuve(id);
    }

}
