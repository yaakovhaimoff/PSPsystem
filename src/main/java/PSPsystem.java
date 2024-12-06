import Models.*;
import utils.Constants;

public class PSPsystem {

    public static void main(String[] args) {
        System.out.println("PSPsystem");
        AcquirerFactory<Acquirer> acquirerFactory = new AcquirerFactory<>();
        acquirerFactory.register(Constants.A, AcquirerA::new);
        acquirerFactory.register(Constants.B, AcquirerB::new);

        RegisterUserPage registerPage = new RegisterUserPage();

        User user = registerPage.registerUser();

        System.out.println("\nModels.User registration complete!");
        System.out.println("Registered Models.User Details:");
        System.out.println(user);

        Acquirer acquirer = acquirerFactory.getObject("A");
        acquirer.setUser(user);

    }
}