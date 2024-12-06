package Models;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Transaction {
    private String cardNumber;
    private String cvv;
    private Double amount;
    private String currency;
    private int merchantID;
    private int expiryMonth;
    private int expiryYear;
    String PSPName;
    TransactionStatus status;
}