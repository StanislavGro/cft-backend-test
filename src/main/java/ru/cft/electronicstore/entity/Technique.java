package ru.cft.electronicstore.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Setter
@Getter
@MappedSuperclass
public abstract class Technique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "generator", strategy = "increment")
    private Long id;

    @NonNull
    private UUID serialNumber;

    @NonNull
    private String manufacturer;

    @NonNull
    private String priceInRubles;

    @NonNull
    private int numberOfUnits;

    public Technique(){
    }

    public Technique(@NonNull UUID serialNumber, @NonNull String manufacturer, @NonNull String priceInRubles, @NonNull int numberOfUnits) {
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.priceInRubles = priceInRubles;
        this.numberOfUnits = numberOfUnits;
    }
}


