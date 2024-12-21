package com.PSPsystem.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentRequest {
    private String cardNumber;
    private String cvv;
    private Double amount;
    private String currency;
    private int merchantID;
    private int expiryMonth;
    private int expiryYear;
}
