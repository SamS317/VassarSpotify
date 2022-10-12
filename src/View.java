import java.util.Scanner;
import java.util.*;


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
                    while(true){
                        List l = new ArrayList();

                        System.out.print("Search (s) or play (p) or logout (l)");
                        String action = scanner.nextLine();
                        if (action.equalsIgnoreCase("l")){
                            System.out.print("Do you want to sign in to different account (y) or (n)");
                            String signInAgain = scanner.nextLine();
                            if (signInAgain.equalsIgnoreCase("y")){
                                break;
                            }
                            else {
                                System.exit(0);
                            }
                        }
                        else if (action.equalsIgnoreCase("s")) {
                            System.out.print("Do you want to search for song (s) or artist (a): ");
                            String songOrArtist = scanner.nextLine();
                            if (songOrArtist.equalsIgnoreCase("s")){
                                System.out.print("Song name: ");
                                String song = scanner.nextLine();
                                l = c.searchSongName(song);
                                for (Object s: l){
                                    System.out.println((Song) s);
                                }
                            }
                            else if (songOrArtist.equalsIgnoreCase("a")){

                                System.out.print("Artist name: ");
                                String artist = scanner.nextLine();
                                l = c.searchArtistName(artist);
                                for (Object s: l){
                                    System.out.println((Song) s);
                                }

                            }

                        }
                        else if (action.equalsIgnoreCase("p")){
                            if (l.size() == 0){
                                System.out.println("You got to search for a song first");
                            }
                            else {
                                System.out.print("Which song do you want (Number of song from top)");
                                int songNum = scanner.nextInt();
                                c.playSong((Song)l.get(songNum));
                            }
                        }
                    }
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
