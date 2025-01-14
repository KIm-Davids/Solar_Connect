package com.semicolon.africa.ports.out;

import com.semicolon.africa.domain.Technician;
import com.semicolon.africa.domain.constants.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TechnicianRepositoryInterface extends JpaRepository<Technician, Long> {

    Optional<Technician> findByTechnicianId(Long id);
    List<Technician> findTechnicianByIsAvailable(Availability isAvailable);
    Technician findTechnicianByEmail(String email);
}
