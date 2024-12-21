package com.PSPsystem.psp.service;

import com.PSPsystem.models.Transaction;
import com.PSPsystem.models.TransactionStatus;
import org.springframework.stereotype.Service;

@Service
public class PaymentProviderService implements PaymentProviderServiceInterface {
    @Override
    public TransactionStatus processPayment(Transaction transaction) {
        String cardNumber = transaction.getPaymentRequest().getCardNumber();
        int lastNumber = Character.getNumericValue( cardNumber.charAt( cardNumber.length() -1 ));
         if( lastNumber % 2 == 0 ) {
             return TransactionStatus.SUCCESS;
         }
         else {
             return TransactionStatus.FAILURE;
         }
    }
}
