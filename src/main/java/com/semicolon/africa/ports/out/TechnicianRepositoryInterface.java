package com.semicolon.africa.ports.out;

import com.semicolon.africa.domain.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnicianRepositoryInterface extends JpaRepository<Technician, Long> {

    Optional<Technician> findByTechnicianId(Long id);

}
