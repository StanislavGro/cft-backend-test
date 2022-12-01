package ru.cft.electronicstore.entity;

import lombok.*;
import ru.cft.electronicstore.entity.enums.LaptopSize;

import javax.persistence.Entity;

@Getter
@Setter
@Builder(setterPrefix = "with")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Laptop extends Technique {
    private LaptopSize size;
}
