package com.example.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.util.Set;

@Entity
@Table(name = "country")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;

    @Column(name="name" ,nullable=false)
    private String name;

    @Column(name="capital",nullable=false)
    private String capital;

    @OneToMany(mappedBy="country",cascade = CascadeType.ALL)
    private Set<EmployeePersonalDetails> empDetails;

}
