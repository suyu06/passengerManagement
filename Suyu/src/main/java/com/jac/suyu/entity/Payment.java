package com.jac.suyu.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "payment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    private int paymentId;

    @Column(name = "cardType")
    private String cardType;

    @Column(name = "cardNumber")
    private int cardNumber;

    @Override
    public String toString() {
        return "card type : " + cardType + " | card number : " + cardNumber;
    }
}
