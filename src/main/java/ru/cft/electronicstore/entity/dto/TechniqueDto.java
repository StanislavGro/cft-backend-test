package ru.cft.electronicstore.entity.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public abstract class TechniqueDto {

    @NonNull
    private Long serialNumber;

    @NonNull
    private String manufacturer;

    @NonNull
    private String price;

    @NonNull
    private int numberOfUnits;

    public TechniqueDto(Long serialNumber, String manufacturer, String price, int numberOfUnits){
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.numberOfUnits = numberOfUnits;
    }
}
