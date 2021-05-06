import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserFileReader{
    private final List<User> USERS = new ArrayList<>();

    public UserFileReader(String path){
        try {
            File userDataCSV = new File(path);
            Scanner userDataScanner = new Scanner(userDataCSV);
            userDataScanner.nextLine();
            while (userDataScanner.hasNext()) {
                String currentLine = userDataScanner.nextLine();
                String[] currentLineArray = currentLine.split(";");
                String cpr = currentLineArray[0].trim();
                String password = currentLineArray[1].trim();
                USERS.add(new User(cpr, password));
            }
        }
        catch (FileNotFoundException err){
            System.err.println("File Not Found");
        }
    }

    public boolean isUser(String cpr){
        Iterator<User> itr = USERS.iterator();
        boolean userExists = false;
        while(itr.hasNext()){
            if (itr.next().getUSER_CPR().equals(cpr)){
                userExists = true;
            }
        }
        return userExists;
    }

    public User getUser(String cpr){
        Iterator<User> userIterator = USERS.iterator();
        while(userIterator.hasNext()){
            User user = userIterator.next();
            if (user.getUSER_CPR().equals(cpr)) {
                return user;
            }
        }
        return null;
    }
}
