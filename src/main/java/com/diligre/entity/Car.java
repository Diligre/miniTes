package com.diligre.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "car")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "car_id_seq")
    @SequenceGenerator(name = "car_id_seq",sequenceName = "car_id_seq",allocationSize = 1)
    private Long id;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "model")
    private Model model;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "configuration")
    private Configure configuration;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "color")
    private Color color;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wheels")
    private Wheels wheels;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "interior")
    private Interior interior;

    @Column(name = "autopilot")
    private Boolean autopilot;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer")
    private Customer customer;

}
