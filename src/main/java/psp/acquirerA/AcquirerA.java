package psp.acquirerA;

import Models.Transaction;
import Models.TransactionStatus;
import psp.PaymentServiceProvider;

public class AcquirerA implements PaymentServiceProvider {


    @Override
    public String getName() {
        return "A";
    }

    @Override
    public TransactionStatus processTransaction(Transaction transaction) {
        return null;
    }
}
