import Models.Transaction;
import utils.Constants;
import validations.Validations;

import java.util.Scanner;

public class RegisterUserPage {

    private final Scanner scanner;

    public RegisterUserPage() {
        this.scanner = new Scanner(System.in);
    }

    public Transaction registerUser() {
        System.out.println(Constants.REGISTER_USER_PROMPT);

        String cardNumber;
        while (true) {
            System.out.print(Constants.ENTER_CARD_NUMBER);
            cardNumber = scanner.nextLine();
            try {
                if (!Validations.isValidCardNumber(cardNumber)) {
                    throw new IllegalArgumentException(Constants.INVALID_CARD_NUMBER);
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String cvv;
        while (true) {
            System.out.print(Constants.ENTER_CVV);
            cvv = scanner.nextLine();
            if (cvv.matches(Constants.CVV_REGEX)) {
                break;
            }
            System.out.println(Constants.INVALID_CVV);
        }

        double amount;
        while (true) {
            try {
                System.out.print(Constants.ENTER_AMOUNT);
                amount = Double.parseDouble(scanner.nextLine());
                if (amount > Constants.MIN_AMOUNT) {
                    break;
                }
                System.out.println(Constants.INVALID_AMOUNT);
            } catch (NumberFormatException e) {
                System.out.println(Constants.INVALID_AMOUNT);
            }
        }

        String currency;
        while (true) {
            System.out.print(Constants.ENTER_CURRENCY);
            currency = scanner.nextLine().toUpperCase();
            if (currency.matches(Constants.CURRENCY_REGEX)) {
                break;
            }
            System.out.println(Constants.INVALID_CURRENCY);
        }

        int merchantID;
        while (true) {
            try {
                System.out.print(Constants.ENTER_MERCHANT_ID);
                merchantID = Integer.parseInt(scanner.nextLine());
                if (merchantID > Constants.MIN_ID) {
                    break;
                }
                System.out.println(Constants.INVALID_MERCHANT_ID);
            } catch (NumberFormatException e) {
                System.out.println(Constants.INVALID_MERCHANT_ID);
            }
        }

        int expiryMonth;
        while (true) {
            try {
                System.out.print(Constants.ENTER_EXPIRY_MONTH);
                expiryMonth = Integer.parseInt(scanner.nextLine());
                if (expiryMonth >= Constants.MIN_MONTH && expiryMonth <= Constants.MAX_MONTH) {
                    break;
                }
                System.out.println(Constants.INVALID_EXPIRY_MONTH);
            } catch (NumberFormatException e) {
                System.out.println(Constants.INVALID_EXPIRY_MONTH);
            }
        }

        int expiryYear;
        while (true) {
            try {
                System.out.print(Constants.ENTER_EXPIRY_YEAR);
                expiryYear = Integer.parseInt(scanner.nextLine());
                int currentYear = java.time.Year.now().getValue();
                if (expiryYear >= currentYear) {
                    break;
                }
                System.out.println(Constants.INVALID_EXPIRY_YEAR + currentYear + ".");
            } catch (NumberFormatException e) {
                System.out.println(Constants.INVALID_EXPIRY_YEAR + ".");
            }
        }

        Transaction transaction = Transaction.builder()
                .cardNumber(cardNumber)
                .cvv(cvv)
                .amount(amount)
                .currency(currency)
                .merchantID(merchantID)
                .expiryMonth(expiryMonth)
                .expiryYear(expiryYear)
                .build();

        System.out.println(Constants.USER_REGISTERED_SUCCESSFULLY);
        System.out.println(transaction);

        return transaction;
    }
}
