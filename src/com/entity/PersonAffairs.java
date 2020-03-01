package com.entity;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonAffairs {

    private int id;
    private String type;
    private String username;
    private String transactionDate;
    private String IDcard;
    private int sectionA;
    private int sectionB;
    private String remark;
}
