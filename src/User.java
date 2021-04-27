public class User {
    private final String USER_CPR;
    private final String USER_PASSWORD;
    private boolean authorized = false;

    public User(String cpr, String password){
        USER_CPR = cpr;
        USER_PASSWORD = password;
    }

    public String getUSER_CPR(){
        return USER_CPR;
    }

    public void signIn(){
        authorized = true;
    }

    public void signOut(){
        authorized = false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (!(obj instanceof User)){
            return false;
        }
        User userToCompare = (User) obj;
        return USER_CPR.equals(userToCompare.USER_CPR) && USER_PASSWORD.equals(userToCompare.USER_PASSWORD);
    }

    @Override
    public String toString(){
        return "User: '" + USER_CPR + "' \nAuthorized status: " + authorized;
    }
}
