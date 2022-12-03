package ru.cft.electronicstore.entity.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class HardDriveDto extends TechniqueDto{

    @NonNull
    private Long volumeInBits;

    public HardDriveDto(@NonNull Long serialNumber, @NonNull String manufacturer, @NonNull String price, @NonNull int numberOfUnits, @NonNull Long volumeInBits) {
        super(serialNumber, manufacturer, price, numberOfUnits);
        this.volumeInBits = volumeInBits;
    }
}
