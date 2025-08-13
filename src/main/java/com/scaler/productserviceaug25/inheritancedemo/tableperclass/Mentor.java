package com.scaler.productserviceaug25.inheritancedemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpv_mentors")
public class Mentor extends User {
    private String company;
    private Double avgRating;
}
