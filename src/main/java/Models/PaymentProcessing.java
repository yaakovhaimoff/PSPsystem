package Models;

public interface PaymentProcessing {

    public String getTransactionStatus();
    public void setTransactionStatus(String transactionStatus);
    public Boolean transaction();
}
