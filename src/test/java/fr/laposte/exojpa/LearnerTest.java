package fr.laposte.exojpa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.laposte.exojpa.model.Learner;
import fr.laposte.exojpa.model.Skill;
import fr.laposte.exojpa.model.Training;
import fr.laposte.exojpa.repository.LearnerRepository;
import fr.laposte.exojpa.repository.SkillRepository;
import fr.laposte.exojpa.repository.TrainingRepository;

@SpringBootTest

class LearnerTest {

	@Autowired
    private LearnerRepository learnerRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private TrainingRepository trainingRepository;

    @Test
    public void testManyToManyRelationship() {

    	// Création d'une compétence
        Skill skill1 = new Skill();
        skill1.setWording("Force Lightning");
        skill1.setLevel(7);

     // Sauvegarde de la compétence
        skillRepository.save(skill1);

     // Création d'un apprenant
        Learner learner = new Learner();
        learner.setName("Dark");
        learner.setSurname("Tyranus 'Count Dooku'");

     // Attribution de la compétence à l'apprenant
        Set<Skill> skills = new HashSet<>();
        skills.add(skill1);

        learner.setSkills(skills);

     // Sauvegarde de l'apprenant avec la compétence
        learnerRepository.save(learner);

     // Récupération de l'apprenant et vérification de la compétence
        Learner retrievedLearner = learnerRepository.findById(learner.getId()).orElse(null);

        assertNotNull(retrievedLearner);
        assertNotNull(retrievedLearner.getSkills());
        assertEquals(1, retrievedLearner.getSkills().size());
    }

    @Test
    public void testManyToOneRelationship() {

    	// Création d'une formation
        Training training = new Training();
        training.setWording("Sith Training Camp");

     // Sauvegarde de la formation
        trainingRepository.save(training);

     // Création d'un apprenant
        Learner learner = new Learner();
        learner.setName("Darth");
        learner.setSurname("Sidious 'Palpatine'");

     // Attribution de la formation à l'apprenant
        learner.setTraining(training);

     // Sauvegarde de l'apprenant avec la formation
        learnerRepository.save(learner);

     // Récupération de l'apprenant et vérification de la formation
        Learner retrievedLearner = learnerRepository.findById(learner.getId()).orElse(null);

        assertNotNull(retrievedLearner);
        assertNotNull(retrievedLearner.getTraining());
        assertEquals("Sith Training Camp", retrievedLearner.getTraining().getWording());
    }

}
