package com.scaler.productserviceaug25.inheritancedemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_tas")
public class TA extends User {
    private int numberOfHRs;
    private Double avgRating;
}
