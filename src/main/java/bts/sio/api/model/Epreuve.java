package bts.sio.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Epreuve")
public class Epreuve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "date_debut")
    private String date_debut;

    @Column(name = "date_fin")
    private String date_fin;

    @ManyToOne
    @JoinColumn(name = "sport_id")
    private Sport sport;
}
