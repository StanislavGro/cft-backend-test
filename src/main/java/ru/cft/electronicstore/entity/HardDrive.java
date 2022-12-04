package ru.cft.electronicstore.entity;

import lombok.*;

import javax.persistence.Entity;
import java.util.UUID;

@Getter
@Setter
@Entity
public class HardDrive extends Technique {

    @NonNull
    private Long volumeInBits;

    public HardDrive(){
    }

    public HardDrive(@NonNull UUID serialNumber, @NonNull String manufacturer, @NonNull String priceInRubles, @NonNull int numberOfUnits, @NonNull Long volumeInBits) {
        super(serialNumber, manufacturer, priceInRubles, numberOfUnits);
        this.volumeInBits = volumeInBits;
    }

    @Override
    public String toString() {
        return "HardDrive: { id = " + getId() +
                ", priceInRubles = " + this.getPriceInRubles() +
                ", manufacturer = " + getManufacturer() +
                ", serial number = " + getSerialNumber() +
                ", number of units = " + getNumberOfUnits() +
                ", volume = " + volumeInBits + " Bit" +
                " }";
    }
}
