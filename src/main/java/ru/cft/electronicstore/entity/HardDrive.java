package ru.cft.electronicstore.entity;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class HardDrive extends Technique {

    private Long volumeInBits;

    public HardDrive(){
    }

    public HardDrive(@NonNull Long serialNumber, @NonNull String manufacturer, @NonNull String price, @NonNull int numberOfUnits, Long volumeInBits) {
        super(serialNumber, manufacturer, price, numberOfUnits);
        this.volumeInBits = volumeInBits;
    }

    @Override
    public String toString() {
        return "HardDrive: { id = " + getId() +
                ", price = " + getPrice() +
                ", manufacturer = " + getManufacturer() +
                ", serial number = " + getSerialNumber() +
                ", number of units = " + getNumberOfUnits() +
                ", volume = " + volumeInBits + " Bit" +
                " }";
    }
}
