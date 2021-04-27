import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NemIdAuthorizer {
    private final UserFileReader USERS;

    NemIdAuthorizer(String pathToData) throws FileNotFoundException {
        this.USERS = new UserFileReader(pathToData);
    }

    public void validateUserSignIn(){
        Scanner takeUserCredentials = new Scanner(System.in);
        boolean validInput = false;
        while(!validInput) {
            try {
                String cpr = takeUserCredentials.nextLine();
                String password = takeUserCredentials.nextLine();
                validInput = isValidInput(cpr, password);
            } catch (WrongCprFormatException err) {
                System.out.println(err.getMessage());
            } catch (NoSuchUserException err){
                System.out.println(err.getMessage());
            }
        }
    }

    private boolean isValidInput(String cpr, String password) throws NoSuchUserException{
        if (cpr.length() != 10){
            throw new WrongCprFormatException("Error in cpr entry: " + cpr);
        } else
        return isUser(cpr,password);
    }

    private boolean isUser(String cpr, String password) {
        if (!USERS.isUser(cpr)){
            throw new NoSuchUserException("No such User was found.");
        } else
        return validateUser(cpr, password);
    }

    private boolean validateUser(String cpr, String password){
        User temp = new User (cpr, password);
        if (USERS.getUser(cpr).equals(temp)){
            authorizeUser(USERS.getUser(cpr));
            return true;
        } else {
            return false;
        }
    }
    private void authorizeUser(User user){
        user.signIn();
        System.out.println(user);
    }
}
