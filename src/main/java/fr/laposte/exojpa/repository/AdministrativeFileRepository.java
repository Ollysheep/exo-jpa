package fr.laposte.exojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.laposte.exojpa.model.AdministrativeFile;

public interface AdministrativeFileRepository extends JpaRepository<AdministrativeFile, Long> {

}
