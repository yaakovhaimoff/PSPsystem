package com.PSPsystem.controller;

import com.PSPsystem.components.paymentProcessor.IPaymentProcessor;
import com.PSPsystem.components.transaction.models.TransactionStatus;
import com.PSPsystem.controller.model.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.PSPsystem.common.ControllerConstants.CARD_PAYMENT_URL;

@RestController
public class PaymentController {

    private final IPaymentProcessor paymentProcessor;

    @Autowired
    public PaymentController(IPaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    @PostMapping(CARD_PAYMENT_URL)
    public TransactionStatus acceptPayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentProcessor.processPayment(paymentRequest);
        // todo need to take transctionResults and modify it to correct https response
    }
}
