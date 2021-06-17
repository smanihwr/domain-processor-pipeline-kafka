package com.example.commons.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Domain {
    private String domain;
    private Date create_date;
    private Date update_date;
    private String country;
    private boolean isDead;
    private List<String> A;
    private List<String> NS;
    private String CNAME;
    private String MX;
    private String TXT;
}
