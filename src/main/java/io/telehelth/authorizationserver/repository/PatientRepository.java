package io.telehelth.authorizationserver.repository;

import io.telehelth.authorizationserver.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Optional<Patient> findByUserId(Long id);
}
