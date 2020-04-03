package com.diligre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "configure")
public class Configure implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "configure_id_seq")
    @SequenceGenerator(name = "configure_id_seq",sequenceName = "configure_id_seq",allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "configuration",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Car> cars;

}
