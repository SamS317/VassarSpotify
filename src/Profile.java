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
        System.out.println(this.username.toLowerCase());
        System.out.println(username.toLowerCase());
        System.out.println(this.password.toLowerCase());
        System.out.println(password.toLowerCase());
        return this.username.toLowerCase().equals(username) && this.password.toLowerCase().equals(password) ;

    }
    public Boolean createUserAccount(String username, String password){

        return true;
    }
}


