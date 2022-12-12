package edu.vassar.cmpu203.vassarspotify;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.vassar.cmpu203.vassarspotify.controller.MainActivity;


@RunWith(AndroidJUnit4.class)
public class AllButtonsTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testStartClicking(){
        //The idea is that all of the buttons should be clickable

        //Logs in first
        FullLoginCreateAccountTest lg = new FullLoginCreateAccountTest();
        lg.logIn("sam", "Genius", true);

        //Home Button
        ViewInteraction searchSongButtonVI = Espresso.onView(ViewMatchers.withId(R.id.homeButton));
        searchSongButtonVI.perform(ViewActions.click());

        //Checks to see if we can create a playlist
        ViewInteraction playlistTextInput = Espresso.onView(ViewMatchers.withId(R.id.playListTextInput));
        playlistTextInput.perform(ViewActions.typeText("Thingy"));

        ViewInteraction createPlaylistButton = Espresso.onView(ViewMatchers.withId(R.id.addPlaylistButton));
        createPlaylistButton.perform(ViewActions.click());

        //Go to Play Screen
        ViewInteraction toPlayScreenButton = Espresso.onView(ViewMatchers.withId(R.id.playButtonHome));
        toPlayScreenButton.perform(ViewActions.click());
    }
}
