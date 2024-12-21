package com.PSPsystem.paymentGateway.controller;

import com.PSPsystem.models.PaymentRequest;
import com.PSPsystem.models.TransactionStatus;

public interface PaymentGateway {
    TransactionStatus assignPSP( PaymentRequest paymentRequest );
}
