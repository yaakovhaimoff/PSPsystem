package com.PSPsystem.controller;

import com.PSPsystem.components.processor.IProcessPayment;
import com.PSPsystem.components.transaction.models.TransactionStatus;
import com.PSPsystem.controller.models.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.PSPsystem.common.Constants.ACCEPT_PAYMENT_URL;
import static com.PSPsystem.common.Constants.CARD_PAYMENT_URL;


@RestController
@RequestMapping(CARD_PAYMENT_URL)
public class PaymentController {

    private final IProcessPayment processPayment;

    @Autowired
    public PaymentController(IProcessPayment processPayment) {
        this.processPayment = processPayment;
    }

    @PostMapping(ACCEPT_PAYMENT_URL)
    public TransactionStatus acceptPayment(@RequestBody PaymentRequest paymentRequest) {
        return processPayment.processPayment(paymentRequest);
        // todo need to take transctionResults and modify it to correct https response
    }
}
