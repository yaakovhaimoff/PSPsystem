package validations;

import utils.Constants;

public class Validations {

    // Validate card number using Luhn's algorithm
    public static boolean isValidCardNumber(String cardNumber) {
        int sum = 0;
        boolean alternate = false;

        // Iterate over the card number from right to left
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(cardNumber.charAt(i));

            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9; // Subtract 9 if the doubled value is greater than 9
                }
            }

            sum += digit;
            alternate = !alternate; // Toggle the alternate flag
        }

        // A valid card number will have a total sum that is a multiple of 10
        return (sum % 10 == 0);
    }

    public static String checkIfEven(int num) {
        return num % Constants.EVEN == Constants.ZERO ? Constants.VALUE_IS_EVEN: Constants.VALUE_IS_ODD;
    }

    public static String validateBIN_Even(String cardNumber) {
        int sum = cardNumber.chars()
                .map(Character::getNumericValue)
                .sum();
        return checkIfEven(sum);
    }

    public static String checkLastDigitEven(String cardNumber) {
        char lastChar = cardNumber.charAt(cardNumber.length() - 1);
        int lastDigit = Character.getNumericValue(lastChar);
        return checkIfEven(lastDigit);
    }

}
