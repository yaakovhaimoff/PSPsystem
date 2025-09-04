package com.PSPsystem.components.paymentProcessor;

import com.PSPsystem.controller.model.PaymentRequest;
import com.PSPsystem.components.transaction.models.TransactionStatus;

public interface IPaymentProcessor {
    TransactionStatus processPayment(PaymentRequest paymentRequest);
}
