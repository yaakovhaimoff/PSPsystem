package com.PSPsystem.components.psp.acquirerA;

import com.PSPsystem.components.psp.IPaymentServiceProvider;
import com.PSPsystem.components.transaction.models.Transaction;
import com.PSPsystem.components.transaction.models.TransactionStatus;
import org.springframework.stereotype.Component;

import static com.PSPsystem.common.PSPConastants.ACQUIRER_A;

@Component
public class AcquirerA implements IPaymentServiceProvider {
    @Override
    public String getName() {
        return ACQUIRER_A;
    }

    @Override
    public TransactionStatus processTransaction(Transaction transaction) {
        int lastDigit = Integer.parseInt(transaction.getPaymentRequest().getCardNumber().substring(transaction.getPaymentRequest().getCardNumber().length() - 1));
        if (lastDigit % 2 == 0) {
            return TransactionStatus.SUCCESS;
        } else {
            return TransactionStatus.FAILURE;
        }
    }
}
