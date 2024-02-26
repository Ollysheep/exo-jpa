package fr.laposte.exojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.laposte.exojpa.model.Learner;

public interface LearnerRepository extends JpaRepository<Learner, Long> {

}
