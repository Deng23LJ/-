package com.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class CarViolation {
    private String carID;
    private String owner;
    private String carType;
    private String violationType;
    private Date violationTime;
    private String violationPlace;
    private String driver;
    private String punishment;


}
