package Models;

import utils.Constants;
import validations.Validations;

public abstract class Acquirer implements PaymentProcessing {
    private User user;
    private String transactionStatus = Constants.PENDING;

    public Acquirer() {}

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Boolean verifyTransaction(String acquirer) {
        String transactionValue = Validations.checkLastDigitEven(getUser().getCardNumber());
        if(transactionValue.equals(acquirer)) {
            setTransactionStatus(Constants.TRANSACTION_SUCCEEDED);
            return true;
        }
        setTransactionStatus(Constants.TRANSACTION_FAILED);
        return false;
    }

    @Override
    public String getTransactionStatus() {
        return this.transactionStatus;
    }

    @Override
    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
