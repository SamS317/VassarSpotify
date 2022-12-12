package edu.vassar.cmpu203.vassarspotify;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.vassar.cmpu203.vassarspotify.controller.MainActivity;


@RunWith(AndroidJUnit4.class)
public class SkipSongTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void testSkipReplayButtons() {
        //Tests if we can queue 2 songs, and skip and replay them each exactly once

        //First login
        FullLoginCreateAccountTest lg = new FullLoginCreateAccountTest();
        lg.logIn("sam", "Genius", true);


        //Add 2 songs to queue
        //Over by Drake
        ViewInteraction searchText = Espresso.onView(ViewMatchers.withId(R.id.search_text));
        searchText.perform(ViewActions.typeText("Over"));

        Espresso.closeSoftKeyboard();
        ViewInteraction searchSongButtonVI = Espresso.onView(ViewMatchers.withId(R.id.search_button));
        searchSongButtonVI.perform(ViewActions.click());

        ViewInteraction queueButton = Espresso.onView(ViewMatchers.withText("Add to\nQueue"));
        queueButton.perform(ViewActions.click());


        //Stronger by Kanye West
        searchText.perform(ViewActions.typeText("Stronger"));

        searchSongButtonVI.perform(ViewActions.click());
        Espresso.closeSoftKeyboard();

        queueButton.perform(ViewActions.click());


        //Go to play screen
        ViewInteraction playButton = Espresso.onView(ViewMatchers.withId(R.id.playButtonHome));
        playButton.perform(ViewActions.click());


        //Check the text is Over by Drake
        ViewInteraction songNameText = Espresso.onView(ViewMatchers.withId(R.id.song_name_PS));
        songNameText.check(ViewAssertions.matches(ViewMatchers.withText("Over")));


        //Click the skip button
        ViewInteraction skipSongButton = Espresso.onView(ViewMatchers.withId(R.id.skipButton));
        skipSongButton.perform(ViewActions.click());


        //Check the text is Stronger by Kanye West
        songNameText.check(ViewAssertions.matches(ViewMatchers.withText("Stronger")));


        //Click the replay button
        ViewInteraction replaySongButton = Espresso.onView(ViewMatchers.withId(R.id.replayButton));
        replaySongButton.perform(ViewActions.click());


        //Check the text is Over by Drake
        songNameText.check(ViewAssertions.matches(ViewMatchers.withText("Over")));
    }
}