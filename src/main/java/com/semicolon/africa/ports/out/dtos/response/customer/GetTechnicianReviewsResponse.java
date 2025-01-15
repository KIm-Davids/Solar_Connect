package com.semicolon.africa.ports.out.dtos.response.customer;

import com.semicolon.africa.domain.Review;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class GetTechnicianReviewsResponse {

    private String message;
    private List<Review> reviewList;

}
