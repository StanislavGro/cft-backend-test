package ru.cft.electronicstore.entity.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class TechniqueDto {

    @NonNull
    private UUID serialNumber;

    @NonNull
    private String manufacturer;

    @NonNull
    private String priceInRubles;

    @NonNull
    private int numberOfUnits;

    public TechniqueDto(UUID serialNumber, String manufacturer, String priceInRubles, int numberOfUnits){
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.priceInRubles = priceInRubles;
        this.numberOfUnits = numberOfUnits;
    }
}
