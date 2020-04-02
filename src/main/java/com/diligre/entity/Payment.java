package com.diligre.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name ="payment")
public class Payment implements Serializable {

    @Column(name = "name_on_card")
    private String nameOnCard;

    @Id
    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiration_month")
    private String expirationMonth;

    @Column(name = "expiration_year")
    private String expirationYear;

    @Column(name = "cvv")
    private String cvv;

    @OneToMany(mappedBy = "payment")
    private Set<Customer> customers;

}
