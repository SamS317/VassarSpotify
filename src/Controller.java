import java.util.*;
public class Controller{
    ProfileDatabase pd = new ProfileDatabase();
    Profile Connor = new Profile("Connor", "Genius");
    Profile Pf = new Profile();
    SongDatabase songList = new SongDatabase();
    Controller (){
        pd.addProfile(Connor);

    }
    List a = new ArrayList();
    public Boolean login(String usernameInput, String password){
        for (Profile p: pd.getProfiles()){
            if (p.username.equalsIgnoreCase(usernameInput)){
                return p.checkLogin(usernameInput, password);
            }

        }
        return false;

    }
    public Boolean createUser(String username, String password ){
        Profile p = new Profile(username, password);
        return pd.addProfile(p);

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
