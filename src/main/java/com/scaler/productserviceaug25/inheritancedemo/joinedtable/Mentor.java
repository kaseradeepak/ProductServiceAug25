package com.scaler.productserviceaug25.inheritancedemo.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_mentors")
public class Mentor extends User {
    private String company;
    private Double avgRating;
}
