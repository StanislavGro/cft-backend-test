package ru.cft.electronicstore.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Monitor extends Technique {

    @NonNull
    private Double diagonalInCm;

    public Monitor() {
    }

    public Monitor(@NonNull UUID serialNumber, @NonNull String manufacturer, @NonNull String priceInRubles, @NonNull int numberOfUnits, @NonNull Double diagonalInCm) {
        super(serialNumber, manufacturer, priceInRubles, numberOfUnits);
        this.diagonalInCm = diagonalInCm;
    }

    @Override
    public String toString() {
        return "Monitor: { id = " + getId() +
                ", priceInRubles = " + this.getPriceInRubles() +
                ", manufacturer = " + getManufacturer() +
                ", serial number = " + getSerialNumber() +
                ", number of units = " + getNumberOfUnits() +
                ", diagonalInCm = " + diagonalInCm +
                " }";
    }
}
