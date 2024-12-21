package com.PSPsystem.paymentGateway.controller;

import com.PSPsystem.models.PaymentRequest;
import com.PSPsystem.models.TransactionStatus;
import com.PSPsystem.paymentGateway.service.Routing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.PSPsystem.utils.tongue.Tongue.PAYMENT_GATEWAY_URL;

@RestController
@RequestMapping( PAYMENT_GATEWAY_URL )
public class PaymentGatewayController implements PaymentGateway {

    private final Routing routing;

    @Autowired
    public PaymentGatewayController( Routing routing ) {
        this.routing = routing;
    }

    @Override
    @PostMapping
    public TransactionStatus assignPSP( @RequestBody PaymentRequest paymentRequest ) {
        return routing.routeToPSP( paymentRequest );
    }
}
