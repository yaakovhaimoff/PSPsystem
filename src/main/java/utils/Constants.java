package utils;

public class Constants {
    public static final String VALUE_IS_ODD = "odd";
    public static final String VALUE_IS_EVEN = "even";
    public static int EVEN = 2;
    public static int ZERO = 0;
    public static final String A = "A";
    public static final String B = "B";

    public static final String REGISTER_USER_PROMPT = "Register a new User";
    public static final String ENTER_CARD_NUMBER = "Enter card number: ";
    public static final String INVALID_CARD_NUMBER = "Invalid card number. Please try again.";
    public static final String ENTER_CVV = "Enter CVV: ";
    public static final String INVALID_CVV = "Invalid CVV. Please enter a 3-digit number.";
    public static final String ENTER_AMOUNT = "Enter amount: ";
    public static final String INVALID_AMOUNT = "Amount must be greater than 0.";
    public static final String ENTER_CURRENCY = "Enter currency (e.g., USD, EUR): ";
    public static final String INVALID_CURRENCY = "Invalid currency. Please enter a 3-letter ISO code (e.g., USD, EUR).";
    public static final String ENTER_MERCHANT_ID = "Enter merchant ID: ";
    public static final String INVALID_MERCHANT_ID = "Merchant ID must be a positive number.";
    public static final String ENTER_EXPIRY_MONTH = "Enter expiry month (1-12): ";
    public static final String INVALID_EXPIRY_MONTH = "Invalid month. Please enter a value between 1 and 12.";
    public static final String ENTER_EXPIRY_YEAR = "Enter expiry year (>= current year): ";
    public static final String INVALID_EXPIRY_YEAR = "Invalid year. Please enter a year greater than or equal to ";
    public static final String USER_REGISTERED_SUCCESSFULLY = "\nUser registered successfully:";
    public static final String CVV_REGEX = "\\d{3}";
    public static final String CURRENCY_REGEX = "[A-Z]{3}";
    public static double MIN_AMOUNT = 0;
    public static int MIN_MONTH = 1;
    public static int MAX_MONTH = 12;
    public static int MIN_ID = 0;

    private Constants() {}
}
