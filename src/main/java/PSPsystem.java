import Models.*;
import psp.PaymentServiceProvider;
import psp.acquirerA.AcquirerA;
import utils.Constants;
import validations.Validations;

public class PSPsystem {

    public static void main(String[] args) {
        System.out.println("PSPsystem");
        AcquirerFactory<PaymentServiceProvider> acquirerFactory = new AcquirerFactory<>();
        acquirerFactory.register(Constants.A, AcquirerA::new);
        acquirerFactory.register(Constants.B, PaymentServiceProviderB::new);

        RegisterUserPage registerPage = new RegisterUserPage();

        Transaction transaction = registerPage.registerUser();

        System.out.println("\nModels.User registration complete!");
        System.out.println("Registered Models.User Details:");
        System.out.println(transaction);

        PaymentServiceProvider paymentServiceProvider = acquirerFactory.getObject("A");

        if (!Validations.validateBIN_Even(transaction.getCardNumber().substring(0, 6))) {
            paymentServiceProvider = acquirerFactory.getObject("B");
        }

        paymentServiceProvider.setUser(transaction);



    }
}