package bts.sio.api.controller;

import bts.sio.api.model.Pays;
import bts.sio.api.model.Ville;
import bts.sio.api.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VilleController {
    @Autowired
    private VilleService villeService;
    /**
     * Read - Get one athlete
     * @param id The id of the athlete
     * @return An Sport object full filled
     */
    @GetMapping("/ville/{id}")
    public Ville getVille(@PathVariable("id") final Long id) {
        Optional<Ville> ville = villeService.getVille(id);
        if(ville.isPresent()) {
            return ville.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all athletes
     * @return - An Iterable object of Athlete full filled
     */
    @GetMapping("/villes")
    public Iterable<Ville> getSports() {
        return villeService.getVilles();
    }

    /**
     * Update - Update an existing athlete
     * @param id - The id of the athlete to update
     * @param ville - The athlete object updated
     * @return
     */
    @PutMapping("/ville/{id}")
    public Ville updateVille(@PathVariable("id") final Long id, @RequestBody Ville ville) {
        Optional<Ville> e = villeService.getVille(id);
        if(e.isPresent()) {
            Ville currentVille = e.get();

            String nom = ville.getNom();
            if(nom != null) {
                currentVille.setNom(nom);
            }

            Pays pays_id = ville.getPays();
            if(pays_id != null) {
                currentVille.setPays(pays_id);;
            }


            villeService.saveVille(currentVille);
            return currentVille;
        } else {
            return null;
        }
    }
}
