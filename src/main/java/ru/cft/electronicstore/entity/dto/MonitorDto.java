package ru.cft.electronicstore.entity.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class MonitorDto extends TechniqueDto{

    @NonNull
    private Double diagonal;

    public MonitorDto(@NonNull Long serialNumber, @NonNull String manufacturer, @NonNull String price, @NonNull int numberOfUnits, @NonNull Double diagonal) {
        super(serialNumber, manufacturer, price, numberOfUnits);
        this.diagonal = diagonal;
    }

}
