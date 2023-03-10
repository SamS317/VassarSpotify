
import java.util.*;
public class SongDatabase {

    List songListReturn = new ArrayList();
    List <Song> songList = new <Song> ArrayList();
    public SongDatabase(){
        songListReturn.clear();
        songList.clear();
        songList.add(new Song("Stronger", "Kanye West"));
        songList.add(new Song("Truth hurts", "Lizzo"));
        songList.add(new Song("Old Town Road", "Lil Nas X"));
        songList.add(new Song("Over", "Drake"));
        songList.add(new Song("Billie Jean", "Michael Jackson"));
        songList.add(new Song("Locked Out of Heaven", "Bruno Mars"));
        songList.add(new Song("Despacito", "Luis Fonsi & Daddy Yankee"));
        songList.add(new Song("Talking to the Moon", "Bruno Mars"));
        songList.add(new Song("Hello", "Adele"));
        songList.add(new Song("Hello", "Eminem"));
        songList.add(new Song("Hello", "Beyonce"));
        songList.add(new Song("Can't Tell Me Nothing", "Kanye West"));

    }
    public List<String> searchSong(String song){
        this.songListReturn.clear();
        for (Song s: this.songList){
            if (s.songName.toUpperCase().equals(song.toUpperCase())){
                this.songListReturn.add(s);
            }
        }
        return this.songListReturn;
    }
    public List<String> searchArtist(String artist){
        this.songListReturn.clear();
        for (Song s: this.songList){
            if (s.artist.toUpperCase().equals(artist.toUpperCase())){
                this.songListReturn.add(s);
            }
        }
        return this.songListReturn;
    }
    public Boolean play(Song song){
        for (Song s : this.songList){
            if (s.songName.toUpperCase().equals(song.songName.toUpperCase()) && (s.artist.toUpperCase().equals(song.artist.toUpperCase()))){
                return true;
            }
        }
        return false;
    }
}
