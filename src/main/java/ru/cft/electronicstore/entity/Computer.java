package ru.cft.electronicstore.entity;

import lombok.*;
import ru.cft.electronicstore.entity.enums.ComputerFormFactor;

import javax.persistence.Entity;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Computer extends Technique {

    @NonNull
    private ComputerFormFactor formFactor;

    public Computer() {
    }

    public Computer(@NonNull UUID serialNumber, @NonNull String manufacturer, @NonNull String priceInRubles, @NonNull int numberOfUnits, @NonNull ComputerFormFactor formFactor) {
        super(serialNumber, manufacturer, priceInRubles, numberOfUnits);
        this.formFactor = formFactor;
    }

    public String toString(){
        return "Computer: { id = " + getId() +
                ", priceInRubles = " + this.getPriceInRubles() +
                ", manufacturer = " + getManufacturer() +
                ", serial number = " + getSerialNumber() +
                ", number of units = " + getNumberOfUnits() +
                ", form factor = " + formFactor +
                " }";
    }
}
