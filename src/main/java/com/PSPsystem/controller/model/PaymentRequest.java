package com.PSPsystem.controller.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentRequest {
    String cardNumber;
    String expiryDate;
    String cvv;
    double amount;
    String currency;
    String merchantId;
}
