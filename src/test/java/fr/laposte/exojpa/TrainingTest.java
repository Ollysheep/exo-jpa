package fr.laposte.exojpa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.laposte.exojpa.model.Training;
import fr.laposte.exojpa.repository.TrainingRepository;

@SpringBootTest

class TrainingTest {

	@Autowired
    private TrainingRepository trainingRepository;

    @Test
    public void testCreateTraining() {
    	
    	// Création d'une formation
        Training training = new Training();
        training.setWording("Jedi Training");

     // Sauvegarde de la formation
        Training savedTraining = trainingRepository.save(training);

     // Vérification que l'identifiant est généré
        assertNotNull(savedTraining.getId());
     // Vérification que le libellé est correct
        assertEquals("Jedi Training", savedTraining.getWording());
    }

}
