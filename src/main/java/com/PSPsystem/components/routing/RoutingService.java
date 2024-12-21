package com.PSPsystem.components.routing;

import com.PSPsystem.components.psp.PSP;
import com.PSPsystem.controller.models.PaymentRequest;
import com.PSPsystem.components.transaction.models.Transaction;
import com.PSPsystem.components.transaction.models.TransactionStatus;
import com.PSPsystem.components.psp.PaymentServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RoutingService implements IRoutingService {

    private final Map < String, PaymentServiceProvider > paymentServiceProviders;

    @Autowired
    public RoutingService(Map< String, PaymentServiceProvider > paymentServiceProviders ) {
        this.paymentServiceProviders = paymentServiceProviders;
    }

    @Override
    public PaymentServiceProvider assignPsp(Transaction transaction) {
        //todo need to return selected PaymentServiceProvider for transction!!
//        Transaction transaction = new Transaction();
//        transaction.setPaymentRequest( paymentRequest );
//        transaction.setStatus( TransactionStatus.PENDING );
//
//        String binNumber = paymentRequest.getCardNumber().substring(0, 6);
//        if( validateBinEven( binNumber ) ) {
//
//        }
//
//        return null;
    }

    private static Boolean checkIfEven( int num ) {
        return num % 2 == 0;
    }

    private static Boolean validateBinEven( String cardNumber ) {
        int sum = cardNumber.chars().map( Character::getNumericValue ).sum();
        return checkIfEven( sum );
    }


}
