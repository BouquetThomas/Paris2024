package bts.sio.api.controller;


import bts.sio.api.model.Olympiade;
import bts.sio.api.model.Sport;
import bts.sio.api.model.Ville;
import bts.sio.api.service.OlympiadeService;
import bts.sio.api.model.Pays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Optional;

@RestController
public class OlympiadeController {

    @Autowired
    private OlympiadeService olympiadeService;
    /**
     * Read - Get one athlete
     * @param olympiade The id of the Olympiade
     * @return An Olympaide object full filled
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
     * Read - Get all olympiades
     * @return - An Iterable object of Athlete full filled
     */
    @GetMapping("/olympiades")
    public Iterable<Olympiade> getLesOlympiades() {
        return olympiadeService.getLesOlympiades()  ;
    }

    @PutMapping("/olympiade/{id}")
    public Olympiade updateOlympiade(@PathVariable("id") final Long id, @RequestBody Olympiade olympiade) {
        Optional<Olympiade> o = olympiadeService.getOlympiade(id);
        if(o.isPresent()) {
            Olympiade currentOlympiade = o.get();


            String numero = olympiade.getNumero();
            if(numero != null) {
                currentOlympiade.setNumero(numero);
            }
            Integer annee = olympiade.getAnnee();
            if(annee != null) {
                currentOlympiade.setAnnee(annee);;
            }
            Ville ville= olympiade.getVille();
            if(ville != null) {
                currentOlympiade.setVille(ville);;
            }

            olympiadeService.saveOlympiade(currentOlympiade);
            return currentOlympiade;
        } else {
            return null;
        }
    }

    @PostMapping("/olympiade")
    public Olympiade createOlympiade(@RequestBody Olympiade olympiade) {
        return olympiadeService.saveOlympiade(olympiade);
    }
    /**
     * Delete - Delete an athlete
     * @param id - The id of the athlete to delete
     */
    @DeleteMapping("/olympiade/{id}")
    public void deleteOlympiade(@PathVariable("id") final Long id) {
        olympiadeService.deleteOlympiade(id);
    }


}
