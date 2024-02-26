package fr.laposte.exojpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class AdministrativeFile {
	
    // Informations du tuteur
	private String tutorName;
	private String tutorMail;
	
	// Relation OneToOne avec l'apprenant (Learner)
    @OneToOne
    private Learner learner;
	
 // Identifiant unique auto-incrémenté
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // indique l'auto-incrément
	private long id;

}
