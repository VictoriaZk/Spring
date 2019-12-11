package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "cipher")
    private String cipher;

    @Min(1)
    @Max(18)
    @Column(name = "lower_discharge")
    private int lowerDischarge;

    @Min(1)
    @Max(18)
    @Column(name = "upper_discharge")
    private int upperDischarge;

}
