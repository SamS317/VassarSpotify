import java.util.Scanner;
import java.util.*;


public class View {
    public static void main(String[] args){
        Boolean is_logged_in;
        //Initialising variables

        Scanner scanner = new Scanner(System.in);
        Controller c = new Controller();
        boolean hold = true;
        String choice;
        String username = "";
        String passwordOne = "";
        String name = "";
        String password = "";
        String name_original = "";
        while(true){
            if (!hold){
                choice = "l";
            }
            else {
                System.out.print("VASSAR SPOTIFY\n\n\n");
                System.out.print("Login (l) or create a new profile (c): ");

                choice = scanner.nextLine();
            }
            //Quitting the program
            if( choice.equalsIgnoreCase("quit") || choice.equalsIgnoreCase("q")){
                break;
            }

            //Logging in

            if( choice.equalsIgnoreCase("l") || choice.equalsIgnoreCase("login")){
                if (hold) {
                    System.out.print("Enter Username: ");
                    name_original = scanner.nextLine();
                    name = name_original.toLowerCase();

                    System.out.print("Enter Password: ");
                    password = scanner.nextLine();
                }
                else {
                     name = username;
                     name_original = name;
                     password = passwordOne;
                }
                if (c.login(name, password) ){
                    System.out.println("Welcome " + name_original + "!");
                    List l = new ArrayList();
                    while(true){
                        int count = 1;
                        System.out.print("Search for a song (s) or play a song (p) or logout (l) ");
                        String action = scanner.nextLine();
                        if (action.equalsIgnoreCase("l") || action.equalsIgnoreCase("logout")){
                            System.out.print("Do you want to sign in to different account (y) or (n) ");
                            String signInAgain = scanner.nextLine();
                            if (signInAgain.equalsIgnoreCase("y")||signInAgain.equalsIgnoreCase("yes")){
                                hold = true;
                                break;
                            }
                            else {
                                System.exit(0);
                            }
                        }
                        else if (action.equalsIgnoreCase("s") || action.equalsIgnoreCase("song")) {
                            System.out.print("Do you want to search for song by song title (s) or by artist (a): ");
                            String songOrArtist = scanner.nextLine();
                            if (songOrArtist.equalsIgnoreCase("s") || songOrArtist.equalsIgnoreCase("song")){
                                System.out.print("Song name: ");
                                String song = scanner.nextLine();
                                count = 1;
                                l = c.searchSongName(song);
                                for (Object s: l){
                                    System.out.print(" (" + count + ") ");
                                    System.out.println((Song) s);
                                    count += 1;
                                }
                            }
                            else if (songOrArtist.equalsIgnoreCase("a") ||songOrArtist.equalsIgnoreCase("artist")){

                                System.out.print("Artist name: ");
                                String artist = scanner.nextLine();
                                l = c.searchArtistName(artist);
                                count = 1;
                                for (Object s: l){
                                    System.out.print(" (" + count + ") ");
                                    System.out.println((Song) s);
                                    count += 1;
                                }

                            }

                        }
                        else if (action.equalsIgnoreCase("p") || action.equalsIgnoreCase("play")){
                            if (l.size() == 0){
                                System.out.println("You got to search for a song first");
                            }
                            else {

                                System.out.print("Which song do you want (Number of song from top) ");
                                int songNum = scanner.nextInt() - 1;
                                scanner.nextLine();
                                if (songNum <= count) {
                                    Boolean b = c.playSong((Song) l.get(songNum));

                                    if (b) {
                                        System.out.println("Playing...");
                                        System.out.println(l.get(songNum));
                                    }
                                }
                                else{
                                    System.out.println("Number not in list try search for a song again");
                                }
                                l.clear();
                            }
                        }
                    }
                }
                else{
                    System.out.println("Log in incorrect, try again");
                }
            }

            //Creating a new profile
            if( choice.equalsIgnoreCase("c") || choice.equalsIgnoreCase("create") ) {
                //Getting new username
                System.out.print("Username: ");
                username = scanner.nextLine();

                //Getting Password
                System.out.print("Password: ");
                passwordOne = scanner.nextLine();
                System.out.print("Re-type password: ");
                String passwordTwo = scanner.nextLine();

                if ( passwordOne.equals(passwordTwo) ){
                    if (c.createUser(username, passwordOne) ){
                        System.out.print("Congrats! " + username + " Your account has been created!\n");
                        hold = false;
                    }
                }
                else if (!passwordOne.equals(passwordTwo)){
                    System.out.println("Oops, passwords don't match, try again");
                }else{
                    System.out.println("Oops, looks like you already have a profile");
                }
            }
        }
    }
}


