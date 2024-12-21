package com.PSPsystem.merchant.service;

import com.PSPsystem.models.PaymentRequest;
import com.PSPsystem.models.Transaction;
import com.PSPsystem.models.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.PSPsystem.utils.tongue.Tongue.HTTP_PAYMENT_GATEWAY_URL;

@Service
public class ProcessPayment implements ProcessPaymentInterface {
    private final RestTemplate restTemplate;

    @Autowired
    public ProcessPayment( RestTemplate restTemplate ) {
        this.restTemplate = restTemplate;
    }

    private boolean validateCardNumberWithLuhnsAlgorithm( String cardNumber ) {
        int sum = 0;
        boolean alternate = false;
        for ( int i = cardNumber.length() - 1; i >= 0; i-- ) {
            int digit = Character.getNumericValue( cardNumber.charAt( i ));
            if ( alternate ) {
                digit *= 2;
                if ( digit > 9 ) {
                    digit -= 9;
                }
            }
            sum += digit;
            alternate = !alternate;
        }
        return ( sum % 10 == 0 );
    }

    @Override
    public TransactionStatus processPayment( PaymentRequest paymentRequest ) {
        if( !this.validateCardNumberWithLuhnsAlgorithm( paymentRequest.getCardNumber() ) ) {
            return TransactionStatus.BAD_REQUEST;
        }
        return restTemplate.postForObject( HTTP_PAYMENT_GATEWAY_URL, paymentRequest, TransactionStatus.class );
    }
}
