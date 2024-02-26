package fr.laposte.exojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.laposte.exojpa.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
