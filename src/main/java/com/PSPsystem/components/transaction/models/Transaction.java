package com.PSPsystem.components.transaction.models;

import com.PSPsystem.controller.models.PaymentRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Transaction {
    final PaymentRequest paymentRequest;
    String PSPName;
    TransactionStatus status;

    public Transaction(PaymentRequest paymentRequest) {
        this.paymentRequest = paymentRequest;
    }


}



