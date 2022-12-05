package ru.cft.electronicstore.entity.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class HardDriveDto extends TechniqueDto{

    @NonNull
    private Long volumeInBits;

    public HardDriveDto(@NonNull UUID serialNumber, @NonNull String manufacturer, @NonNull String priceInRubles, @NonNull int numberOfUnits, @NonNull Long volumeInBits) {
        super(serialNumber, manufacturer, priceInRubles, numberOfUnits);
        this.volumeInBits = volumeInBits;
    }
}
