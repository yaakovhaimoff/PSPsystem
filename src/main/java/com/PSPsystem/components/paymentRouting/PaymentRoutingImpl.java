package com.PSPsystem.components.paymentRouting;

import com.PSPsystem.components.psp.IPaymentServiceProvider;
import com.PSPsystem.components.psp.acquirerA.AcquirerA;
import com.PSPsystem.components.psp.acquirerB.AcquirerB;
import com.PSPsystem.components.transaction.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.PSPsystem.common.PSPConastants.ACQUIRER_A;
import static com.PSPsystem.common.PSPConastants.ACQUIRER_B;

@Service
public class PaymentRoutingImpl implements IPaymentRouting {
    private final Map< String, IPaymentServiceProvider> paymentServiceProviders;

    @Autowired
    public PaymentRoutingImpl(AcquirerA acquirerA, AcquirerB acquirerB) {
        this.paymentServiceProviders = Map.of(
                ACQUIRER_A, acquirerA,
                ACQUIRER_B, acquirerB
        );
    }
    @Override
    public IPaymentServiceProvider assignPsp(Transaction transaction) {
        String cardNumber = transaction.getPaymentRequest().getCardNumber();
        int binSum = 0;
        for (int i = 0; i < cardNumber.length(); i++) {
            binSum += Character.getNumericValue(cardNumber.charAt(i));
        }

        String selectedPSPName = (binSum % 2 == 0) ? ACQUIRER_A : ACQUIRER_B;
        return paymentServiceProviders.get(selectedPSPName);
    }
}
