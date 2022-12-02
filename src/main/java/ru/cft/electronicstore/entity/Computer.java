package ru.cft.electronicstore.entity;

import lombok.*;
import ru.cft.electronicstore.entity.enums.ComputerFormFactor;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Computer extends Technique {

    private ComputerFormFactor formFactor;

    public Computer() {
    }

    public Computer(@NonNull Long serialNumber, @NonNull String manufacturer, @NonNull String price, @NonNull int numberOfUnits, ComputerFormFactor formFactor) {
        super(serialNumber, manufacturer, price, numberOfUnits);
        this.formFactor = formFactor;
    }

    public String toString(){
        return "Computer: { id = " + getId() +
                ", price = " + getPrice() +
                ", manufacturer = " + getManufacturer() +
                ", serial number = " + getSerialNumber() +
                ", number of units = " + getNumberOfUnits() +
                ", form factor = " + formFactor +
                " }";
    }
}
