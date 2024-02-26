package fr.laposte.exojpa.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Training {
	
	// Libellé de la formation
	private String wording;
	
    // Relation OneToMany avec les apprenants (Learner)
    @OneToMany(mappedBy = "training")
    private Set<Learner> learners = new HashSet<>();
	
 // Identifiant unique auto-incrémenté
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // indique l'auto-incrément
	private long id;

}
