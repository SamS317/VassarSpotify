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
public class LoginTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    public void logIn(String username, String password){
        //Logs in user with specified username and password
        ViewInteraction usernameVI = Espresso.onView(ViewMatchers.withId(R.id.username));
        usernameVI.perform(ViewActions.typeText(username));

        ViewInteraction passwordVI = Espresso.onView(ViewMatchers.withId(R.id.password));
        passwordVI.perform(ViewActions.typeText(password));

        Espresso.closeSoftKeyboard();

        ViewInteraction loginButtonVI = Espresso.onView(ViewMatchers.withId(R.id.logInButton));
        loginButtonVI.perform(ViewActions.click());
    }

    @Test
    public void usernameAndPasswordTest() {
        //Checks logging in works given the pre-existing username and password
        logIn("Connor", "Genius");

        //If the button is not clickable the fragment didn't open
        ViewInteraction searchButtonOnSearchFragment = Espresso.onView(ViewMatchers.withId(R.id.search_button));
        searchButtonOnSearchFragment.perform(ViewActions.click());
    }

    @Test
    public void faultyPasswordTest(){
        logIn("Connor", "g");

        ViewInteraction logGate = Espresso.onView(ViewMatchers.withId(R.id.logInGate));
        logGate.check(ViewAssertions.matches(ViewMatchers.withText("Incorrect password or username")));

    }
}