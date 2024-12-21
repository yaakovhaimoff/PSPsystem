package com.PSPsystem.paymentGateway.service;

import com.PSPsystem.models.PaymentRequest;
import com.PSPsystem.models.Transaction;
import com.PSPsystem.models.TransactionStatus;
import com.PSPsystem.psp.PaymentServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Routing implements RoutingInterface {

    private final Map < String, PaymentServiceProvider > paymentServiceProviders;

    @Autowired
    public Routing( Map< String, PaymentServiceProvider > paymentServiceProviders ) {
        this.paymentServiceProviders = paymentServiceProviders;
    }

    @Override
    public TransactionStatus routeToPSP(PaymentRequest paymentRequest) {
        Transaction transaction = new Transaction();
        transaction.setPaymentRequest( paymentRequest );
        transaction.setStatus( TransactionStatus.PENDING );

        String binNumber = paymentRequest.getCardNumber().substring(0, 6);
        if( validateBinEven( binNumber ) ) {

        }

        return null;
    }

    private static Boolean checkIfEven( int num ) {
        return num % 2 == 0;
    }

    private static Boolean validateBinEven( String cardNumber ) {
        int sum = cardNumber.chars().map( Character::getNumericValue ).sum();
        return checkIfEven( sum );
    }


}
