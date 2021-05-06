public class NoSuchUserException extends RuntimeException{
    public NoSuchUserException(){
        super("User was not found");
    }
}
