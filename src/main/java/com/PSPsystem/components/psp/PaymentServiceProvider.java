package com.PSPsystem.components.psp;


import com.PSPsystem.components.transaction.models.Transaction;
import com.PSPsystem.components.transaction.models.TransactionStatus;

public interface PaymentServiceProvider {
    public String getName();
    public TransactionStatus processTransaction( Transaction transaction );
}
