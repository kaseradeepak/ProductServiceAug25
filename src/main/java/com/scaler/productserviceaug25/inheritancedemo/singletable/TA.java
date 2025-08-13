package com.scaler.productserviceaug25.inheritancedemo.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_tas")
@DiscriminatorValue(value = "3")
public class TA extends User {
    private int numberOfHRs;
    private Double avgRating;
}
