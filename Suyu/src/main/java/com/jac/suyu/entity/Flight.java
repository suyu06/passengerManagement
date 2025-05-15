package com.jac.suyu.entity;


import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "flight")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "passengers")
@EqualsAndHashCode(exclude = "passengers")

public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flightId")
    private int flightId;

    @Column(name = "fromCity")
    private String fromCity;

    @Column(name = "departureDate")
    private Date departureDate;

    @Column(name = "departureTime")
    private Time departureTime;

    @Column(name = "toCity")
    private String toCity;

    @Column(name = "destinationDate")
    private Date destinationDate;

    @Column(name = "destinationTime")
    private Time destinationTime;

    @ManyToMany(mappedBy = "flights")
    private Set<Passenger> passengers = new HashSet<>();
}
