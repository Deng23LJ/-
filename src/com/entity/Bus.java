package com.entity;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bus {

    private  int busID;
    private String originStation;
    private String lastStation;
    private String passStation;
}
