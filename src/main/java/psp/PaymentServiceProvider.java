package psp;

import Models.Transaction;
import Models.TransactionStatus;

public interface PaymentServiceProvider {
    public String getName();
    public TransactionStatus processTransaction(Transaction transaction);
}
