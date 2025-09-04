package com.PSPsystem.components.psp;

import com.PSPsystem.components.transaction.models.Transaction;
import com.PSPsystem.components.transaction.models.TransactionStatus;

public interface IPaymentServiceProvider {
    String getName();
    TransactionStatus processTransaction(Transaction transaction );
}
