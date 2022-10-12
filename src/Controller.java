import java.util.*;
public class Controller{

    Profile Connor = new Profile("Connor", "Genius");
    Profile Pf = new Profile();
    SongDatabase songList = new SongDatabase();
    Controller (){


    }
    List a = new ArrayList();
    public Boolean login(String username, String password){
        return Connor.checkLogin(username, password);
    }
    public Boolean createUser(String username, String password ){
        return Pf.createUserAccount(username, password);
    }
    public List<String> searchSongName(String song){
        return songList.searchSong(song);
    }
    public List<String> searchArtistName(String artist){
        return songList.searchArtist(artist);
    }
    public Boolean playSong(Song song){
        return songList.play(song);
    }

}

//the methods that view calls in order to do shit
//controller has a bunch of methods that each have different things they do
//such as login, play, search
//but these methods call model because the model is the thing DOING things


//Make fake database using lists (where is still unknown)