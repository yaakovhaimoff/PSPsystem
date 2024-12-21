package com.PSPsystem.psp;


import com.PSPsystem.models.Transaction;
import com.PSPsystem.models.TransactionStatus;

public interface PaymentServiceProvider {
    public String getName();
    public TransactionStatus processTransaction( Transaction transaction );
}
