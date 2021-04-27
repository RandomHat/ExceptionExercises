import java.io.FileNotFoundException;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        NemIdAuthorizer nemId = new NemIdAuthorizer("Users/UserData.csv");
        System.out.println("Enter cpr and password:");
        nemId.validateUserSignIn();
    }
}
