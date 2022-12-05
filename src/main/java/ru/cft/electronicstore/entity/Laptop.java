package ru.cft.electronicstore.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ru.cft.electronicstore.entity.enums.LaptopSize;

import javax.persistence.Entity;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Laptop extends Technique {

    @NonNull
    private LaptopSize size;

    public Laptop() {
    }

    public Laptop(@NonNull UUID serialNumber, @NonNull String manufacturer, @NonNull String priceInRubles, @NonNull int numberOfUnits, @NonNull LaptopSize size) {
        super(serialNumber, manufacturer, priceInRubles, numberOfUnits);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Laptop: { id = " + getId() +
                ", priceInRubles = " + this.getPriceInRubles() +
                ", manufacturer = " + getManufacturer() +
                ", serial number = " + getSerialNumber() +
                ", number of units = " + getNumberOfUnits() +
                ", size = " + size +
                " }";
    }
}
