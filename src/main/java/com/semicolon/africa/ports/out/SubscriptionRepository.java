package com.semicolon.africa.ports.out;

import com.semicolon.africa.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Optional<Subscription> findSubscriptionByTechnicianId(long id);

}
