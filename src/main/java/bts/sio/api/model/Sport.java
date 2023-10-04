package bts.sio.api.model;


import jakarta.persistence.*;
import lombok.Data;

import javax.lang.model.element.NestingKind;
import java.util.Set;

@Data
@Entity
@Table(name ="sport")
    public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "descriptif")
    private String descriptif;

    @Column(name = "nomImage")
    private String nomImage;

    @ManyToOne
    @JoinColumn(name = "olympiade_id")
    private Olympiade olympiade;

    @OneToMany (mappedBy = "sport")
    private Set<Epreuve> LesEpreuves;


}
