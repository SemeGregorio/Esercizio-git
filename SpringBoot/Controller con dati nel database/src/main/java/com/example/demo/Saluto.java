package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Saluti")
public class Saluto {

    @Id
    private int id;

    private String testo;

    public Saluto() {
    }

    public int getId() {
        return id;
    }

    public String getTesto() {
        return testo;
    }
}