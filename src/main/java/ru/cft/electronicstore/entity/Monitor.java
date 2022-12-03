package ru.cft.electronicstore.entity;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Monitor extends Technique {

    @NonNull
    private Double diagonal;

    public Monitor() {
    }

    public Monitor(@NonNull Long serialNumber, @NonNull String manufacturer, @NonNull String price, @NonNull int numberOfUnits, @NonNull Double diagonal) {
        super(serialNumber, manufacturer, price, numberOfUnits);
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "Monitor: { id = " + getId() +
                ", price = " + getPrice() +
                ", manufacturer = " + getManufacturer() +
                ", serial number = " + getSerialNumber() +
                ", number of units = " + getNumberOfUnits() +
                ", diagonal = " + diagonal +
                " }";
    }
}
