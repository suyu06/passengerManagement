package com.jac.suyu.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "passenger")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "flights")
@EqualsAndHashCode(exclude = "flights")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passengerId")
    private int passengerId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "gender")
    private String gender;

    @OneToOne
    @JoinColumn(name = "payment", referencedColumnName = "paymentId")
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "address", referencedColumnName = "addressID")
    private Address address;


    @ManyToMany
    @JoinTable(name = "passenger_flight", joinColumns = {@JoinColumn(name = "passengerId")},
            inverseJoinColumns = {@JoinColumn(name = "flightId")})
    private Set<Flight> flights = new HashSet<>();
}
