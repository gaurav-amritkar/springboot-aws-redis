package com.awsredis.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Customer implements Serializable {

    private Long custId;
    private String custFirstName;
    private String custLastName;
    private String custEmailId;
    private int custAge;
}
