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
public class SearchSongTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void searchSongAndResultsTest(){
        //Logs in first
        FullLoginCreateAccountTest lg = new FullLoginCreateAccountTest();
        lg.logIn("sam","Genius", true);


        //Checks searching for a song gives results
        ViewInteraction searchText = Espresso.onView(ViewMatchers.withId(R.id.search_text));
        searchText.check(ViewAssertions.matches(ViewMatchers.withText("")));

        searchText.perform(ViewActions.typeText("Over"));

        //Only look up songs
        ViewInteraction songChoiceButtonVI = Espresso.onView(ViewMatchers.withId(R.id.songChoiceButtonId));
        songChoiceButtonVI.perform(ViewActions.click());

        ViewInteraction searchSongButtonVI = Espresso.onView(ViewMatchers.withId(R.id.search_button));
        searchSongButtonVI.perform(ViewActions.click());

        //Clicks the first song to bring us to the play screen
        ViewInteraction playButton = Espresso.onView(ViewMatchers.withText("Over\nDrake"));
        playButton.perform(ViewActions.click());

        //If button isn't clickable then there isn't a button and therefore the search result didn't work
        ViewInteraction checkSongTitle = Espresso.onView(ViewMatchers.withId(R.id.song_name_PS));
        checkSongTitle.check(ViewAssertions.matches(ViewMatchers.withText("Over")));
    }

}