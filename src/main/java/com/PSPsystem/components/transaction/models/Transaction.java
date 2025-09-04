package com.PSPsystem.components.transaction.models;

import com.PSPsystem.controller.model.PaymentRequest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Transaction {
    PaymentRequest paymentRequest;
    String PSPName;
    TransactionStatus transactionStatus;

    public Transaction(PaymentRequest paymentRequest) {
        this.paymentRequest = paymentRequest;
        this.transactionStatus = TransactionStatus.PENDING;
    }
}
