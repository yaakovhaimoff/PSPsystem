package psp.acquirerB;

import Models.Transaction;
import Models.TransactionStatus;
import psp.PaymentServiceProvider;
import utils.Constants;

public class AcquirerB implements PaymentServiceProvider {
    @Override
    public String getName() {
        return "B";
    }

    @Override
    public TransactionStatus processTransaction(Transaction transaction) {
        return null;
    }
}
