package com.diligre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "color")
public class Color implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "color_id_seq")
    @SequenceGenerator(name = "color_id_seq", sequenceName = "color_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @OneToMany(mappedBy = "color")
    @JsonIgnore
    private Set<Car> cars;

}
