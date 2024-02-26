package fr.laposte.exojpa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.laposte.exojpa.model.Learner;
import fr.laposte.exojpa.model.Skill;
import fr.laposte.exojpa.repository.LearnerRepository;
import fr.laposte.exojpa.repository.SkillRepository;
import jakarta.transaction.Transactional;

@SpringBootTest
class SkillTest {
	
    @Autowired
    private LearnerRepository learnerRepository;

	@Autowired
	private SkillRepository skillRepository;
	
	@Test
	public void testCreateSkill() {
		
		// Création d'une compétence
	    Skill skill = new Skill();
	    skill.setWording("Telekinesis");
	    skill.setLevel(3);

	 // Sauvegarde de la compétence
	    Skill savedSkill = skillRepository.save(skill);

	 // Vérification que l'identifiant est généré
	    assertNotNull(savedSkill.getId());
	    
	 // Vérification que le libellé et le niveau sont corrects
	    assertEquals("Telekinesis", savedSkill.getWording());
	    assertEquals(3, savedSkill.getLevel());
	}
	
	@Transactional
	@Test
	public void testManyToManyRelationship() {

		// Création d'un apprenant
	    Learner learner = new Learner();
	    learner.setName("Luke");
	    learner.setSurname("Skywalker");

	 // Sauvegarde de l'apprenant
	    learnerRepository.save(learner);

	 // Création de deux compétences
	    Skill skill1 = new Skill();
	    skill1.setWording("Telekinesis");
	    skill1.setLevel(3);

	    Skill skill2 = new Skill();
	    skill2.setWording("Lightsaber Combat");
	    skill2.setLevel(4);

	 // Sauvegarde des compétences
	    skillRepository.save(skill1);
	    skillRepository.save(skill2);

	 // Attribution des compétences à l'apprenant
	    Set<Skill> skills = new HashSet<>();
	    skills.add(skill1);
	    skills.add(skill2);

	    learner.setSkills(skills);

	 // Sauvegarde de l'apprenant avec les compétences
	    learnerRepository.save(learner);

	 // Récupération de l'apprenant et vérification des compétences
	    Learner retrievedLearner = learnerRepository.findById(learner.getId()).orElse(null);

	    assertNotNull(retrievedLearner);
	    assertNotNull(retrievedLearner.getSkills());
	    assertEquals(2, retrievedLearner.getSkills().size());
	}
}
