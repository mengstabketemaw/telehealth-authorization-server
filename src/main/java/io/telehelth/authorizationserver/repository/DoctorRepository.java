package io.telehelth.authorizationserver.repository;

import io.telehelth.authorizationserver.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
