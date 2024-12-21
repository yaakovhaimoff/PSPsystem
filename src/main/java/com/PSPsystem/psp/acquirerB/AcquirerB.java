package com.PSPsystem.psp.acquirerB;

import com.PSPsystem.models.Transaction;
import com.PSPsystem.models.TransactionStatus;
import com.PSPsystem.psp.PaymentServiceProvider;
import com.PSPsystem.psp.service.PaymentProviderService;
import com.PSPsystem.utils.tongue.Tongue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AcquirerB implements PaymentServiceProvider {

    private final PaymentProviderService paymentProviderService;

    @Autowired
    public AcquirerB( PaymentProviderService paymentProviderService ) {
        this.paymentProviderService = paymentProviderService;
    }
    @Override
    public String getName() {
        return Tongue.ACQUIRER_B;
    }
    @Override
    public TransactionStatus processTransaction(Transaction transaction) {
        return paymentProviderService.processPayment( transaction );
    }
}
