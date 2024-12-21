package com.PSPsystem.components.processor;

import com.PSPsystem.components.psp.PaymentServiceProvider;
import com.PSPsystem.components.routing.IRoutingService;
import com.PSPsystem.components.transaction.models.Transaction;
import com.PSPsystem.controller.models.PaymentRequest;
import com.PSPsystem.components.transaction.models.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessPaymentImp implements IProcessPayment {


    private final IRoutingService routingService;

    @Autowired
    public ProcessPaymentImp( IRoutingService routingService ) {
        this.routingService = routingService;
    }

    @Override
    public TransactionStatus processPayment( PaymentRequest paymentRequest ) {
        if( !this.validateCardNumberWithLuhnsAlgorithm( paymentRequest.getCardNumber() ) ) {
            return TransactionStatus.BAD_REQUEST;
        }
        Transaction transaction = new Transaction(paymentRequest);
        PaymentServiceProvider selectedPSP = routingService.assignPsp( transaction );
        transaction.setPSPName( selectedPSP.getName() );

        TransactionStatus status = selectedPSP.processTransaction( transaction );
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
