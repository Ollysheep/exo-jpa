package fr.laposte.exojpa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.laposte.exojpa.model.AdministrativeFile;
import fr.laposte.exojpa.model.Learner;
import fr.laposte.exojpa.repository.AdministrativeFileRepository;
import fr.laposte.exojpa.repository.LearnerRepository;
import jakarta.transaction.Transactional;

@SpringBootTest

class AdministrativeFileTest {

	 @Autowired
	    private AdministrativeFileRepository administrativeFileRepository;

	    @Autowired
	    private LearnerRepository learnerRepository;

	    @Test
	    public void testCreateAdministrativeFile() {
	    	
	    	// Création d'un dossier administratif
	        AdministrativeFile administrativeFile = new AdministrativeFile();
	        administrativeFile.setTutorName("Obi-Wan Kenobi");
	        administrativeFile.setTutorMail("ben-kenobi@jedi.cor");

	     // Sauvegarde du dossier administratif
	        AdministrativeFile savedFile = administrativeFileRepository.save(administrativeFile);

	     // Vérification que l'identifiant est généré
	        assertNotNull(savedFile.getId());
	        
	     // Vérification que les informations sont correctes
	        assertEquals("Obi-Wan Kenobi", savedFile.getTutorName());
	        assertEquals("ben-kenobi@jedi.cor", savedFile.getTutorMail());
	    }

	    // environnement de test isolé préservant l'intégrité des données de la base de données de test car
	    // les opérations dans la méthode annotée doivent être exécutées dans une transaction
	    @Transactional
	    
	    @Test
	    public void testOneToOneRelationship() {
	        Learner learner = new Learner();
	        learner.setName("Luke");
	        learner.setSurname("Skywalker");

	        AdministrativeFile administrativeFile = new AdministrativeFile();
	        administrativeFile.setTutorName("Anakin Skywalker");
	        administrativeFile.setTutorMail("kinsky@jedi.cor");

	        // Attribution du dossier administratif à l'apprenant
	        learner.setAdministrativeFile(administrativeFile);

	     // Sauvegarde de l'apprenant avec le dossier administratif
	        learnerRepository.save(learner);


	    }
	}
