package com.PSPsystem.merchant.controller;

import com.PSPsystem.merchant.service.ProcessPayment;
import com.PSPsystem.models.PaymentRequest;
import com.PSPsystem.models.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.PSPsystem.utils.tongue.Tongue.ACCEPT_PAYMENT_URL;
import static com.PSPsystem.utils.tongue.Tongue.PAYMENT_MERCHANT_URL;

@RestController
@RequestMapping( PAYMENT_MERCHANT_URL )
public class MerchantController implements Merchant{

    private final ProcessPayment processPayment;

    @Autowired
    public MerchantController( ProcessPayment processPayment ) {
        this.processPayment = processPayment;
    }

    @Override
    @PostMapping( ACCEPT_PAYMENT_URL )
    public TransactionStatus acceptPayment( @RequestBody PaymentRequest paymentRequest ) {
        return processPayment.processPayment( paymentRequest );
    }
}
