package com.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Chat {

    private Date time;
    private String send;
    private String receive;
    private String chatContent;
}
