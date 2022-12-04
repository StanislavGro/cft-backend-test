package ru.cft.electronicstore.entity.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ru.cft.electronicstore.entity.enums.LaptopSize;

import java.util.UUID;

@Setter
@Getter
public class LaptopDto extends TechniqueDto {

    @NonNull
    private LaptopSize size;

    public LaptopDto(@NonNull UUID serialNumber, @NonNull String manufacturer, @NonNull String priceInRubles, @NonNull int numberOfUnits, @NonNull LaptopSize size) {
        super(serialNumber, manufacturer, priceInRubles, numberOfUnits);
        this.size = size;
    }
}
