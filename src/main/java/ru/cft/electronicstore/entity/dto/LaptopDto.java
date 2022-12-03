package ru.cft.electronicstore.entity.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ru.cft.electronicstore.entity.enums.LaptopSize;

@Setter
@Getter
public class LaptopDto extends TechniqueDto {

    @NonNull
    private LaptopSize size;

    public LaptopDto(@NonNull Long serialNumber, @NonNull String manufacturer, @NonNull String price, @NonNull int numberOfUnits, @NonNull LaptopSize size) {
        super(serialNumber, manufacturer, price, numberOfUnits);
        this.size = size;
    }
}
