package com.PSPsystem.components.processor;

import com.PSPsystem.controller.models.PaymentRequest;
import com.PSPsystem.components.transaction.models.TransactionStatus;

public interface IProcessPayment {
    TransactionStatus processPayment( PaymentRequest paymentRequest );
}
