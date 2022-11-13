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
public class searchSongTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void searchSongAndResultsTest(){
        //Logs in first
        // SIDE NOTE -> I tried forever to make the logging in part a method as i knew I would be testing this a lot
        ViewInteraction usernameVI = Espresso.onView(ViewMatchers.withId(R.id.username));
        usernameVI.perform(ViewActions.typeText("Connor"));

        ViewInteraction passwordVI = Espresso.onView(ViewMatchers.withId(R.id.password));
        passwordVI.perform(ViewActions.typeText("Genius"));

        Espresso.closeSoftKeyboard();

        ViewInteraction loginButtonVI = Espresso.onView(ViewMatchers.withId(R.id.logInButton));
        loginButtonVI.perform(ViewActions.click());


        //Checks searching for a song gives results
        ViewInteraction searchText = Espresso.onView(ViewMatchers.withId(R.id.search_text));
        searchText.check(ViewAssertions.matches(ViewMatchers.withText("")));

        searchText.perform(ViewActions.typeText("Over"));

        searchText.check(ViewAssertions.matches(ViewMatchers.withText("Over")));

        //Only look up songs
        ViewInteraction songChoiceButtonVI = Espresso.onView(ViewMatchers.withId(R.id.songChoiceButtonId));
        songChoiceButtonVI.perform(ViewActions.click());

        ViewInteraction searchSongButtonVI = Espresso.onView(ViewMatchers.withId(R.id.search_button));
        searchSongButtonVI.perform(ViewActions.click());

        //If button isn't clickable then there isn't a button and therefore the search result didn't work
        Espresso.onView(ViewMatchers.withText("play")).check(ViewAssertions.matches(ViewMatchers.isClickable()));
    }

}