package ru.cft.electronicstore.entity;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@Builder(setterPrefix = "with")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HardDrive extends Technique {
    private Long volumeInBits;
}
