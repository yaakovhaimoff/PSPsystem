package com.PSPsystem.paymentGateway.service;

import com.PSPsystem.models.PaymentRequest;
import com.PSPsystem.models.TransactionStatus;

public interface RoutingInterface {
    public TransactionStatus routeToPSP(PaymentRequest paymentRequest );
}
