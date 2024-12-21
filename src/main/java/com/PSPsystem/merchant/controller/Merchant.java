package com.PSPsystem.merchant.controller;

import com.PSPsystem.models.PaymentRequest;
import com.PSPsystem.models.TransactionStatus;
import org.springframework.web.bind.annotation.RequestBody;

public interface Merchant {
    public TransactionStatus acceptPayment( @RequestBody PaymentRequest paymentRequest );
}
