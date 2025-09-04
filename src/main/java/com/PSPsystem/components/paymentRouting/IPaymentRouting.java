package com.PSPsystem.components.paymentRouting;

import com.PSPsystem.components.psp.IPaymentServiceProvider;
import com.PSPsystem.components.transaction.models.Transaction;
import com.PSPsystem.components.transaction.models.TransactionStatus;

public interface IPaymentRouting {
    IPaymentServiceProvider assignPsp(Transaction transaction);
}
