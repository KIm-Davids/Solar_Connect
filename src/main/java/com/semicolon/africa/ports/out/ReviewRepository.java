package com.semicolon.africa.ports.out;

import com.semicolon.africa.domain.Review;
import com.semicolon.africa.domain.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findReviewByTechnician_TechnicianId(Long technician);
}
