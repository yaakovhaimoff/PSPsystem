package com.PSPsystem.psp.service;

import com.PSPsystem.models.Transaction;
import com.PSPsystem.models.TransactionStatus;

public interface PaymentProviderServiceInterface {
    TransactionStatus processPayment(Transaction transaction );
}
