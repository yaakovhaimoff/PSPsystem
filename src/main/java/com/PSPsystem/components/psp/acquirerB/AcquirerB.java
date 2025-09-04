package com.PSPsystem.components.psp.acquirerB;

import com.PSPsystem.components.psp.IPaymentServiceProvider;
import com.PSPsystem.components.transaction.models.Transaction;
import com.PSPsystem.components.transaction.models.TransactionStatus;
import static com.PSPsystem.common.PSPConastants.ACQUIRER_B;
import org.springframework.stereotype.Service;


@Service
public class AcquirerB implements IPaymentServiceProvider {
    @Override
    public String getName() {
        return ACQUIRER_B;
    }

    @Override
    public TransactionStatus processTransaction(Transaction transaction) {
        int lastDigit = Integer.parseInt(transaction.getPaymentRequest().getCardNumber().substring(transaction.getPaymentRequest().getCardNumber().length() - 1));
        if( lastDigit % 2 == 0 ) {
            return TransactionStatus.SUCCESS;
        } else {
            return TransactionStatus.FAILURE;
        }
    }
}
