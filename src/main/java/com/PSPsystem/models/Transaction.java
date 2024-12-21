package com.PSPsystem.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Transaction {
    PaymentRequest paymentRequest;
    String PSPName;
    TransactionStatus status;
}