package com.PSPsystem.merchant.service;

import com.PSPsystem.models.PaymentRequest;
import com.PSPsystem.models.TransactionStatus;

public interface ProcessPaymentInterface {
    TransactionStatus processPayment( PaymentRequest paymentRequest );
}
