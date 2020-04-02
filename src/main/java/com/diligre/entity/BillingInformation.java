package com.diligre.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "billing_infromation")
public class BillingInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "billing_information_id_seq")
    @SequenceGenerator(name = "billing_information_id_seq",sequenceName = "billing_information_id_seq",allocationSize = 1)
    private Long id;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private Integer postalCode;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "billingInformation")
    @JsonIgnore
    private Set<Customer> customers;

}
