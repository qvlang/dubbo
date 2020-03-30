package com.lang.dubbo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private final static long serialVersionUID = 6666666666666l;
    private Long userId;
    private String username;
    private String password;
    private String address;
    private String gender;
    private Date birthDate;
}
