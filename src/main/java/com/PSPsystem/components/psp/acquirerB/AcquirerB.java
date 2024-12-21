package com.PSPsystem.components.psp.acquirerB;

import com.PSPsystem.common.Constants;
import com.PSPsystem.components.transaction.models.Transaction;
import com.PSPsystem.components.transaction.models.TransactionStatus;
import com.PSPsystem.components.psp.PaymentServiceProvider;
import com.PSPsystem.components.psp.service.PaymentProviderService;
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
        return Constants.ACQUIRER_B;
    }
    @Override
    public TransactionStatus processTransaction(Transaction transaction) {
        return paymentProviderService.processPayment( transaction );
    }
}
