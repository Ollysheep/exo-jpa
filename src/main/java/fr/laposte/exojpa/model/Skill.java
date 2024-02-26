package fr.laposte.exojpa.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Skill {
	
    // Libellé et niveau de compétence
	private String wording;
	private Integer level;
	
    // Relation ManyToMany avec les apprenants (Learner)
    @ManyToMany(mappedBy = "skills")
    private Set<Learner> learners = new HashSet<>();
	
 // Identifiant unique auto-incrémenté
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // indique l'auto-incrément
	private long id;

}
