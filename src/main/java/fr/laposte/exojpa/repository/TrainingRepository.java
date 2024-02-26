package fr.laposte.exojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.laposte.exojpa.model.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {

}
