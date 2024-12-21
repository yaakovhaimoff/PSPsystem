package com.PSPsystem.components.psp.service;

import com.PSPsystem.components.transaction.models.Transaction;
import com.PSPsystem.components.transaction.models.TransactionStatus;

public interface PaymentProviderServiceInterface {
    TransactionStatus processPayment(Transaction transaction );
}
