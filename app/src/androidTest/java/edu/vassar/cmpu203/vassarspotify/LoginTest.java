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
public class LoginTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void usernameAndPasswordTest() {
        //Checks logging in works given the pre-existing username and password
        ViewInteraction usernameVI = Espresso.onView(ViewMatchers.withId(R.id.username));
        usernameVI.perform(ViewActions.typeText("Connor"));

        ViewInteraction passwordVI = Espresso.onView(ViewMatchers.withId(R.id.password));
        passwordVI.perform(ViewActions.typeText("Genius"));

        Espresso.closeSoftKeyboard();

        ViewInteraction loginButtonVI = Espresso.onView(ViewMatchers.withId(R.id.logInButton));
        loginButtonVI.perform(ViewActions.click());
    }
}