import java.util.Scanner;

public class View {
    public static void main(String[] args){
        Boolean is_logged_in;
        //Initialising variables

        Scanner scanner = new Scanner(System.in);
        Controller c = new Controller();

        while(true){
            System.out.print("VASSAR SPOTIFY\n\n\n");
            System.out.print("Login (l) or create a new profile (c)");

            String choice = scanner.nextLine();

            //Quitting the program
            if( choice.equalsIgnoreCase("quit") || choice.equalsIgnoreCase("q")){
                break;
            }

            //Logging in
            if( choice.equalsIgnoreCase("l") ){
                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Password: ");
                String password = scanner.nextLine();

                if (c.login(name, password) ){
                    System.out.print("Welcome " + name + "!");
                }
            }

            //Creating a new profile
            if( choice.equalsIgnoreCase("c") ) {
                //Getting new username
                System.out.print("Username: ");
                String username = scanner.nextLine();

                //Getting Password
                System.out.print("Password: ");
                String passwordOne = scanner.nextLine();
                System.out.print("Re-type password: ");
                String passwordTwo = scanner.nextLine();

                if ( passwordOne.equals(passwordTwo) ){
                    if (c.createUser(username, passwordOne) ){
                        System.out.print("Congrats! " + username + " Your account has been created!");
                    }
                } else{
                    System.out.print("Oops, looks like you already have a profile");
                }
            }
        }
    }
}

//All print and scanner (input) statements should live here
//view asks for username and passwords
//ONLY THING ASKING FOR SCANNER INPUT
//
