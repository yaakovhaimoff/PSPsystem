package com.PSPsystem.components.routing;

import com.PSPsystem.components.psp.PSP;
import com.PSPsystem.components.psp.PaymentServiceProvider;
import com.PSPsystem.components.transaction.models.Transaction;
import com.PSPsystem.controller.models.PaymentRequest;
import com.PSPsystem.components.transaction.models.TransactionStatus;

public interface IRoutingService {
    public PaymentServiceProvider assignPsp(Transaction transaction );
}
