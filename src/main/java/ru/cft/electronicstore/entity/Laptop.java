package ru.cft.electronicstore.entity;

import lombok.*;
import ru.cft.electronicstore.entity.enums.LaptopSize;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Laptop extends Technique {
    private LaptopSize size;

    public Laptop() {
    }

    public Laptop(@NonNull Long serialNumber, @NonNull String manufacturer, @NonNull String price, @NonNull int numberOfUnits, LaptopSize size) {
        super(serialNumber, manufacturer, price, numberOfUnits);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Laptop: { id = " + getId() +
                ", price = " + getPrice() +
                ", manufacturer = " + getManufacturer() +
                ", serial number = " + getSerialNumber() +
                ", number of units = " + getNumberOfUnits() +
                ", size = " + size +
                " }";
    }
}
