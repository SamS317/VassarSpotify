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
        return this.username.equals(username) && this.password.equals(password) ;

    }
    public Boolean createUserAccount(String username, String password){
        return true;
    }
}

//this is in the model thing
//the profile has the fields username and passwords
//THE LOGIC OF LOGIN SHOULD BE DONE HERE
//DOES THIS USERNAME AND PASSWORD WORK TOGETHER
