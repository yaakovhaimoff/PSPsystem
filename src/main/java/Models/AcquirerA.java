package Models;

import utils.Constants;

public class AcquirerA extends Acquirer {
    public Boolean transaction() {
        return verifyTransaction(Constants.VALUE_IS_EVEN);
    }
}
