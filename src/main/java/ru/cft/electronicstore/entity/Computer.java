package ru.cft.electronicstore.entity;

import lombok.*;
import ru.cft.electronicstore.entity.enums.ComputerFormFactor;

import javax.persistence.Entity;

@Getter
@Setter
@Builder(setterPrefix = "with")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Computer extends Technique {
    private ComputerFormFactor formFactor;
}
