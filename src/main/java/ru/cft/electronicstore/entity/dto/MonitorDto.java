package ru.cft.electronicstore.entity.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MonitorDto extends TechniqueDto {

    @NonNull
    private Double diagonalInCm;

    public MonitorDto(@NonNull UUID serialNumber, @NonNull String manufacturer, @NonNull String priceInRubles, @NonNull int numberOfUnits, @NonNull Double diagonalInCm) {
        super(serialNumber, manufacturer, priceInRubles, numberOfUnits);
        this.diagonalInCm = diagonalInCm;
    }

}
