package ru.cft.electronicstore.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Technique {

    private Long id;

    private UUID serialNumber;

    private String manufacturer;

    private String price;

    private int numberOfUnits;

}


