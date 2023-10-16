package bts.sio.api.controller;


import bts.sio.api.model.Olympiade;
import bts.sio.api.model.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bts.sio.api.service.SportService;

import java.util.List;
import java.util.Optional;

@RestController
public class SportController {

    @Autowired
    private SportService sportService;

    /**
     * Create - Add a new athlete
     * @param sport An object athlete
     * @return The  object saved
     */
    @PostMapping("/sport")
    public Sport createSport(@RequestBody Sport sport) {
        return sportService.saveSport(sport);
    }


    /**
     * Read - Get one athlete
     * @param id The id of the athlete
     * @return An Sport object full filled
     */
    @GetMapping("/sport/{id}")
    public Sport getSport(@PathVariable("id") final Long id) {
        Optional<Sport> sport = sportService.getSport(id);
        if(sport.isPresent()) {
            return sport.get();
        } else {
            return null;
        }
    }

    @GetMapping("/sports/olympiade/{olympiade_id}")
    public List<Sport> getSportsByOlympiade(@PathVariable("olympiade_id") final Long olympiade_id) {
        return sportService.getSportsByOlympiade_id(olympiade_id);
    }

    /**
     * Read - Get all athletes
     * @return - An Iterable object of Athlete full filled
     */
    @GetMapping("/sports")
    public Iterable<Sport> getSports() {
        return sportService.getSports();
    }

    /**
     * Update - Update an existing athlete
     * @param id - The id of the athlete to update
     * @param sport - The athlete object updated
     * @return
     */
    @PutMapping("/sport/{id}")
    public Sport updateSport(@PathVariable("id") final Long id, @RequestBody Sport sport) {
        Optional<Sport> e = sportService.getSport(id);
        if(e.isPresent()) {
            Sport currentSport = e.get();

            String nom = sport.getNom();
            if(nom != null) {
                currentSport.setNom(nom);
            }
            String descriptif = sport.getDescriptif();
            if(descriptif != null) {
                currentSport.setDescriptif(descriptif);;
            }
            String nom_image = sport.getNom_image();
            if(nom_image != null) {
                currentSport.setNom_image(nom_image);;
            }
            Olympiade olympiade_id = sport.getOlympiade();
            if(olympiade_id != null) {
                currentSport.setOlympiade(olympiade_id);;
            }


            sportService.saveSport(currentSport);
            return currentSport;
        } else {
            return null;
        }
    }


    /**
     * Delete - Delete an athlete
     * @param id - The id of the athlete to delete
     */
    @DeleteMapping("/sport/{id}")
    public void deleteAthlete(@PathVariable("id") final Long id) {
        sportService.deleteSport(id);
    }

}
