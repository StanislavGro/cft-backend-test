package ru.cft.electronicstore.entity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ru.cft.electronicstore.entity.enums.ComputerFormFactor;

@Getter
@Setter
public class ComputerDto extends TechniqueDto{

    @NonNull
    private ComputerFormFactor formFactor;

    public ComputerDto(@NonNull Long serialNumber, @NonNull String manufacturer, @NonNull String price, @NonNull int numberOfUnits, @NonNull ComputerFormFactor formFactor) {
        super(serialNumber, manufacturer, price, numberOfUnits);
        this.formFactor = formFactor;
    }
}
