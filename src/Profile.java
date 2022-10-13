public class Profile {
    String username;
    String password;
    public Profile (String username, String password){
        this.username = username;
        this.password = password;
    }
    public  Profile (){

    }
    public Boolean checkLogin(String username, String password){
        return this.username.toLowerCase().equals(username) && this.password.toLowerCase().equals(password) ;

    }
    public Boolean createUserAccount(String username, String password){

        return true;
    }
}


