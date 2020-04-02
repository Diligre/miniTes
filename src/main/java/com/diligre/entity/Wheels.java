package com.diligre.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "wheels")
public class Wheels implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wheels_id_seq")
    @SequenceGenerator(name = "wheels_id_seq", sequenceName = "wheels_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @OneToMany(mappedBy = "wheels")
    private Set<Car> cars;

}
