package com.scaler.productserviceaug25.inheritancedemo.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_tas")
public class TA extends User {
    private int numberOfHRs;
    private Double avgRating;
}
