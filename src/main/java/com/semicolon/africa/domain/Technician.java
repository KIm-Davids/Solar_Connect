package com.semicolon.africa.domain;

import com.semicolon.africa.domain.constants.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
//@ToString
public class Technician extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long technicianId;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Enumerated(EnumType.STRING)
    private Availability isAvailable;
    @OneToMany(mappedBy = "technician")
    private List<Review> review;
    private String certificationPic;
    private String technicianPic;
    private String  isCertified;
//    @OneToOne
//    @JoinColumn(name = "subscription_id")
//    private Subscription subscription;

    @Override
    public String toString() {
        return "Technician{id=" + technicianId + ", first name= '" + getFirstName() + " last name= " + getLastName() + "', isAvailable=" + isAvailable + "}";
    }


}
