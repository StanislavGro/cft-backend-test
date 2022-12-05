package ru.cft.electronicstore.entity.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import ru.cft.electronicstore.entity.enums.ComputerFormFactor;

import java.util.UUID;

@Getter
@Setter
public class ComputerDto extends TechniqueDto {

    @NonNull
    private ComputerFormFactor formFactor;

    public ComputerDto(@NonNull UUID serialNumber, @NonNull String manufacturer, @NonNull String priceInRubles, @NonNull int numberOfUnits, @NonNull ComputerFormFactor formFactor) {
        super(serialNumber, manufacturer, priceInRubles, numberOfUnits);
        this.formFactor = formFactor;
    }
}
