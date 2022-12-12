package edu.vassar.cmpu203.vassarspotify.model;

import static java.lang.Integer.parseInt;

import android.util.Pair;

import java.util.*;

import edu.vassar.cmpu203.vassarspotify.R;

/**
 * Provides a method to contain all songs
 *
 * Later implementations will be able to communicate with a database
 * Later implementations will not have a constructor with pre made songs
 */
public class SongDatabase {

    List<Song> songListReturn = new <Song>ArrayList<Song>();
    List<Song> songList = new <Song>ArrayList<Song>();
    List<String> songRList = new <String>ArrayList<String>();

    public SongDatabase() {
        songListReturn.clear();
        songList.clear();
        songList.add(new Song("Stronger", "Kanye West"));
        songList.add(new Song("Truth hurts", "Lizzo"));
        songList.add(new Song("Old Town Road", "Lil Nas X"));
        songList.add(new Song("Over", "Drake"));
        songList.add(new Song("Billie Jean", "Michael Jackson"));
        songList.add(new Song("Locked Out of Heaven", "Bruno Mars"));
        songList.add(new Song("Despacito", "Luis Fonsi and Daddy Yankee"));
        songList.add(new Song("Talking to the Moon", "Bruno Mars"));
        songList.add(new Song("Hello", "Adele"));
        songList.add(new Song("Hello", "Eminem"));
        songList.add(new Song("Halo", "Beyonce"));
        songList.add(new Song("Cant Tell Me Nothing", "Kanye West"));
        songList.add(new Song("Leaving West Virginia", "Lathy Mattea"));

        songRList.add("R.raw.kanyeweststronger@@kanye west stronger");
        songRList.add("R.raw.truthhurtslizzo@@truth hurts lizzo");
        songRList.add("R.raw.oldtownroadlilnasx@@old town road lil nas x");
        songRList.add("R.raw.overdrake@@over drake");
        songRList.add("R.raw.billiejeanmichaeljackson@@billie jean michael jackson");
        songRList.add("R.raw.lockedoutofheavenbrunomars@@locked out of heaven bruno mars");
        songRList.add("R.raw.despacitoluisfonsidaddyyankee@@despacito luis fonsi and daddy yankee");
        songRList.add("R.raw.talkingtothemoonbrunomars@@talking to the moon bruno mars");
        songRList.add("R.raw.helloadele@@hello adele");
        songRList.add("R.raw.hellobeyonce@@halo beyonce");
        songRList.add("R.raw.helloeminem@@hello eminem");
        songRList.add("R.raw.canttellmeanythingkanyewest@@cant tell me nothing kanye west");
        songRList.add("R.raw.leavingwestvirginialathymattea@@leaving west virginia lathy mattea");


    }

    /**
     * Provides a way to search for a song in the current song database
     * <p>
     * This method only returns the songs that match the song title with the input string best
     * <p>
     * Later implementation should possibly combine searchSong and searchArtist
     *
     * @param song The string that will be used to search the database
     * @return Returns a list of songs that matches the input string
     */
    public List<Song> searchSong(String song) {
        List<Song> songList = new <Song>ArrayList<Song>();
        for (Song s : this.songList) {
            if (s.songName.toUpperCase().contains(song.toUpperCase())) {
                songList.add(s);
            }
        }
        return songList;
    }

    public List<Song> searchArtist(String artist) {
        List<Song> songList = new <Song>ArrayList<Song>();
        for (Song s : this.songList) {
            if (s.artist.toUpperCase().contains(artist.toUpperCase())) {
                songList.add(s);
            }
        }
        return songList;
    }

    public Object getRaddress(String song, String artist) {
        for (String s : this.songRList) {
            String[] ssplit = s.split("@@");
            String raddres = ssplit[0];
            String nameSong = ssplit[1].toLowerCase();
            String songLower = song.toLowerCase();
            String artistLower = artist.toLowerCase();
            if (nameSong.contains(songLower) && nameSong.contains(artistLower)) {
                return getRData(nameSong);
            }


        }
        return null;

    }

    public Object getRData(String name) {
        if (Objects.equals(name, "kanye west stronger")) {
            return R.raw.kanyeweststronger;
        } else if (Objects.equals(name, "truth hurts lizzo")) {
            return R.raw.truthhurtslizzo;
        } else if (Objects.equals(name, "old town road lil nas x")) {
            return R.raw.oldtownroadlilnasx;
        } else if (Objects.equals(name, "over drake")) {
            return R.raw.overdrake;
        } else if (Objects.equals(name, "billie jean michael jackson")) {
            return R.raw.billiejeanmichaeljackson;
        } else if (Objects.equals(name, "locked out of heaven bruno mars")) {
            return R.raw.lockedoutofheavenbrunomars;
        } else if (Objects.equals(name, "despacito luis fonsi and daddy yankee")) {
            return R.raw.despacitoluisfonsidaddyyankee;
        } else if (Objects.equals(name, "talking to the moon bruno mars")) {
            return R.raw.talkingtothemoonbrunomars;
        } else if (Objects.equals(name, "hello adele")) {
            return R.raw.helloadele;
        } else if (Objects.equals(name, "halo beyonce")) {
            return R.raw.halobeyonce;
        } else if (Objects.equals(name, "hello eminem")) {
            return R.raw.helloeminem;
        } else if (Objects.equals(name, "cant tell me nothing kanye west")) {
            return R.raw.canttellmeanythingkanyewest;
        } else if (Objects.equals(name, "leaving west virginia lathy mattea")) {
            return R.raw.leavingwestvirginialathymattea;
        } else {
            return R.raw.leavingwestvirginialathymattea;
        }
    }

    public Song getSong(String songName, String artistName) {
        for (Song s : this.songList) {
            if (s.songName.toUpperCase().equals(songName.toUpperCase()) && (s.artist.toUpperCase().equals(artistName.toUpperCase()))) {
                return s;
            }
        }
        return new Song("Take my breath away", "Berlin");
    }

    public Song getRandomSong() {
        return new Song("Over", "Drake");
    }

    public String getString(String name, String artist) {
        if (name.equals("Stronger")&&artist.equals("Kanye West")){
            return "kanyeweststronger";
        }
        else if (name.equals("Truth hurts")&&artist.equals("Lizzo")){
            return "truthhurtslizzo";
        }
        else if (name.equals("Old Town Road")&&artist.equals("Lil Nas X")){
            return "oldtownroadlilnasx";
        }
        else if (name.equals("Over")&&artist.equals("Drake")){
            return "overdrake";
        }
        else if (name.equals("Billie Jean")&&artist.equals("Michael Jackson")){
            return "billiejeanmichaeljackson";
        }
        else if (name.equals("Locked Out of Heaven")&&artist.equals("Bruno Mars")){
            return "lockedoutofheavenbrunomars";
        }
        else if (name.equals("Despacito")&&artist.equals("Luis Fonsi and Daddy Yankee")){
            return "despacitoluisfonsidaddyyankee";
        }
        else if (name.equals("Talking to the Moon")&&artist.equals("Bruno Mars")){
            return "talkingtothemoonbrunomars";
        }
        else if (name.equals("Hello")&&artist.equals("Adele")){
            return "helloadele";
        }
        else if (name.equals("Hello")&&artist.equals("Eminem")){
            return "helloeminem";
        }
        else if (name.equals("Halo")&&artist.equals("Beyonce")){
            return "halobeyonce";
        }
        else if (name.equals("Cant Tell Me Nothing")&&artist.equals("Kanye West")){
            return "canttellmeanythingkanyewest";
        }
        else if (name.equals("Leaving West Virginia")&&artist.equals("Lathy Mattea")){
            return "R.raw.leavingwestvirginialathymattea";
        }
        else {
            return "truthhurtslizzo";
        }


    }
}