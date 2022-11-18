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
public class CreateAccountTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void createUserTest(){
        //Testing to see if creating a user works
        ViewInteraction usernameVI = Espresso.onView(ViewMatchers.withId(R.id.username));
        usernameVI.perform(ViewActions.typeText("Jose"));

        ViewInteraction passwordVI = Espresso.onView(ViewMatchers.withId(R.id.password));
        passwordVI.perform(ViewActions.typeText("password123"));

        Espresso.closeSoftKeyboard();

        ViewInteraction loginButtonVI = Espresso.onView(ViewMatchers.withId(R.id.createButton));
        loginButtonVI.perform(ViewActions.click());
    }
}
