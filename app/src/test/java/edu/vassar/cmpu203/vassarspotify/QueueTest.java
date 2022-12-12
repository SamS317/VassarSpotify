package edu.vassar.cmpu203.vassarspotify;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import edu.vassar.cmpu203.vassarspotify.model.Queue;
import edu.vassar.cmpu203.vassarspotify.model.Song;

public class QueueTest {
    Queue q = new Queue();
    Song s = new Song("Over","Drake");
    Song s2 = new Song("Dream On","Aerosmith");
    Song s3 = new Song("I'm Back","Eminem");

    Song voidReturn = new Song("Take my breath away","Berlin");

    @Test
    void testAll(){
        //Tests all methods in queue
        //getCurrentSong, getNext, getPrevious, clearQueue
        q.addSong(s);
        q.addSong(s2);
        q.addSong(s3);

        assertEquals(s, q.getCurrentSong());
        assertEquals(s2, q.getNext(s));
        assertEquals(s2, q.getPrevious(s3));

        q.clearQueue();

        //Currently if no song is selected "voidReturn" will return
        assertEquals(voidReturn, q.getCurrentSong());
    }
}