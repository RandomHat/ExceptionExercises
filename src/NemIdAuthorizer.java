import java.io.FileNotFoundException;
import java.util.Scanner;

public class NemIdAuthorizer {
    private final UserFileReader USERS;
    private final String NUMBERS = "0123456789";
    private final String LETTERS = "abcdefghijklmnopqrstuvxyz";
    private final String LEGAL_CHARS = "{}!#\"$’%^&,*()_+-=:;?.@ ";

    NemIdAuthorizer(String pathToData){
        this.USERS = new UserFileReader(pathToData);
    }

    public void validateUserSignIn(){
        Scanner takeUserCredentials = new Scanner(System.in);
        boolean validInput = false;
        while(!validInput) try {
            String cpr = takeUserCredentials.nextLine();
            String password = takeUserCredentials.nextLine();
            validInput = isValidInput(cpr, password);
            if (validateUser(cpr, password)) {
                authorizeUser(USERS.getUser(cpr));
            }
        } catch (RuntimeException err) {
            System.out.println(err.getMessage());
        }
    }

    public boolean isValidInput(String cpr, String password){
        if (!isValidCpr(cpr)){
            throw new WrongCprFormatException();
        }
        if (!isUser(cpr)){
            throw new NoSuchUserException();
        }
        if (!(isValidPassword(password) || isValidPin(password))){
            throw new RuntimeException("1");
        }
        if (!hasNumbers(password)){
            throw new RuntimeException("2");
        }
        if (hasIllegalChars(password)){
            throw new RuntimeException("3");
        }
        if (hasIllegalChars(password)){
            throw new RuntimeException("4");
        }
        if (isValidPassword(password)){
            if (!hasLetters(password)){
                throw new RuntimeException("5");
            }
            if (hasIllegalBlank(password)){
                throw new RuntimeException("6");
            }
            if (containsCpr(cpr, password)){
                throw new RuntimeException("7");
            }
        }
        if (isValidPin(password)) {
            if (hasSequenceFromCpr(cpr, password)) {
                throw new RuntimeException("8");
            }
            if (isANumberSeries(password)){
                throw new RuntimeException("9");
            }
            if (hasLetters(password)){
                throw new RuntimeException("10");
            }
        }
        return true;
    }


    boolean validateUser(String cpr, String password){
        User temp = new User (cpr, password);
        if (USERS.getUser(cpr).equals(temp)){
            authorizeUser(USERS.getUser(cpr));
            return true;
        } else {
            return false;
        }
    }


    void authorizeUser(User user){
        user.signIn();
        System.out.println(user);
    }


    // Cpr methods
    boolean isValidCpr(String cpr){
        return cpr.length() == 10;
    }


    boolean isUser(String cpr) {
        return USERS.isUser(cpr);
    }


    // General password methods
    boolean hasNumbers(String password){
        for (char a:
                NUMBERS.toCharArray()) {
            if (password.contains(String.valueOf(a))){
                return true;
            }

        }
        return false;
    }


    boolean hasIllegalChars(String password){
        String testString = LEGAL_CHARS + NUMBERS + LETTERS;
        for (char a:
                password.toCharArray()) {
            if (!testString.contains(String.valueOf(a))){
                return true;
            }
        }
        return false;
    }


    boolean hasRepeatChars(String password){
        for (int i = 0; i<password.length(); i += 4) {
            char a = password.charAt(i);
            char[] data = {a,a,a,a};
            String repeat = new String(data);
            if (password.contains(repeat)){
                return true;
            }
        }
        return false;
    }


    boolean isValidPassword(String password){
        return (password.length() > 6 && password.length() < 40);
    }

    boolean hasLetters(String password){
        for (char a:
             LETTERS.toCharArray()) {
            if (password.toLowerCase().contains(String.valueOf(a))){
                return true;
            }

        }
        return false;
    }


    boolean hasIllegalBlank(String password){
        return password.startsWith(" ") || password.endsWith(" ");
    }


    boolean containsCpr(String cpr, String password){
        return password.contains(cpr);
    }


    boolean isValidPin(String password){
        return password.length() == 4;
    }


    boolean hasSequenceFromCpr(String cpr, String password){
        for (int i = 0; i<password.length()-3;i++){
            if (password.contains(cpr.subSequence(i, i+3))){
                return true;
            }
        }
        return false;
    }


    boolean isANumberSeries(String password){
        char[] data = password.toCharArray();
        return data[0] == data[1]-1 && data[2]-2 == data[3]-3;
    }
}
