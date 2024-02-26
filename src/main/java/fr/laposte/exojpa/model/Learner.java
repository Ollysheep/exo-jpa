package fr.laposte.exojpa.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Learner {
	
    // Informations de l'apprenant
	private String name;
	private String surname;
	
    // Relation ManyToMany avec les compétences (Skill)
    @ManyToMany
    private Set<Skill> skills = new HashSet<>();

    // Relation ManyToOne avec la formation (Training)
    @ManyToOne
    private Training training;

    // Relation OneToOne avec le dossier administratif (AdministrativeFile)
    @OneToOne(mappedBy = "learner")
    private AdministrativeFile administrativeFile;
	
 // Identifiant unique auto-incrémenté
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // indique l'auto-incrément
	private long id;

}
