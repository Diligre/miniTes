package com.diligre.entity;

import lombok.Data;
import lombok.Generated;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "interior")
public class Interior implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interior_id_seq")
    @SequenceGenerator(name = "interior_id_seq", sequenceName = "interior_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String decription;

    @OneToMany(mappedBy = "interior")
    private Set<Car> cars;

}
