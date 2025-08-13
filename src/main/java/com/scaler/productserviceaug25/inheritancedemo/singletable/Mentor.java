package com.scaler.productserviceaug25.inheritancedemo.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_mentors")
@DiscriminatorValue(value = "2")
public class Mentor extends User {
    private String company;
    private Double avgRating;
}
