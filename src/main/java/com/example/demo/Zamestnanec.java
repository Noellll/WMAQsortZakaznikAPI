package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Zamestnanec {
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getRodneCislo() {
        return rodneCislo;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String rodneCislo;
    public Zamestnanec(){}
    public Zamestnanec(String name,String rodneCislo){this.name=name;this.rodneCislo=rodneCislo;}
}
