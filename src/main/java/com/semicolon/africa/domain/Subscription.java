package com.semicolon.africa.domain;

import com.semicolon.africa.domain.constants.SubscriptionStatus;
import com.semicolon.africa.domain.constants.SubscriptionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionId;
    private long technicianId;
    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;
    private LocalDate startDate;
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private SubscriptionStatus subscriptionStatus;

    private void setSubscriptionId(long id){
        this.subscriptionId = id;
    }

    private long getSubscriptionId(){
        return subscriptionId;
    }

}
