package com.example.service_voiture.dto;

public class Car {

    public Long id;
    public String marque;
    public String modele;
    public Long clientId;

    public Car(Long id, String marque, String modele, Long clientId) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.clientId = clientId;
    }
}

