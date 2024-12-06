package Models;

import utils.Constants;

public class AcquirerB extends Acquirer {
    public Boolean transaction() {
        return verifyTransaction(Constants.VALUE_IS_ODD);
    }
}
