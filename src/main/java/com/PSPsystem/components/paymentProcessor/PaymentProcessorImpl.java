package com.PSPsystem.components.paymentProcessor;

import com.PSPsystem.components.paymentRouting.IPaymentRouting;
import com.PSPsystem.components.psp.IPaymentServiceProvider;
import com.PSPsystem.components.transaction.models.Transaction;
import com.PSPsystem.controller.model.PaymentRequest;
import com.PSPsystem.components.transaction.models.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentProcessorImpl implements IPaymentProcessor{
    private final IPaymentRouting paymentRouting;

    @Autowired
    public PaymentProcessorImpl(IPaymentRouting paymentRouting) {
        this.paymentRouting = paymentRouting;
    }

    @Override
    public TransactionStatus processPayment( PaymentRequest paymentRequest ) {
        if( !this.validateCardNumberWithLuhnsAlgorithm( paymentRequest.getCardNumber() ) ) {
            return TransactionStatus.BAD_REQUEST;
        }
        Transaction transaction = new Transaction(paymentRequest);
        IPaymentServiceProvider selectedPSP = paymentRouting.assignPsp( transaction );
        transaction.setPSPName(selectedPSP.getName());

        TransactionStatus status = selectedPSP.processTransaction(transaction);
        //todo return transctionResult not status, if there is error? needs to have also some message indicate error type

        return status;
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
}
