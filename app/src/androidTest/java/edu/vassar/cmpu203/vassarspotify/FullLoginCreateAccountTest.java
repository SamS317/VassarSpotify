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
public class FullLoginCreateAccountTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    public void logIn(String username, String password, boolean login){
        //If login is true it'll click the login button
        //If its false it'll click the create user button

        //Logs in user with specified username and password
        ViewInteraction usernameVI = Espresso.onView(ViewMatchers.withId(R.id.username));
        usernameVI.perform(ViewActions.typeText(username));

        ViewInteraction passwordVI = Espresso.onView(ViewMatchers.withId(R.id.password));
        passwordVI.perform(ViewActions.typeText(password));

        Espresso.closeSoftKeyboard();


        ViewInteraction loginButtonVI;
        if(login) {
            loginButtonVI = Espresso.onView(ViewMatchers.withId(R.id.logInButton));
        }else{
            loginButtonVI = Espresso.onView(ViewMatchers.withId(R.id.createButton));
        }
        loginButtonVI.perform(ViewActions.click());
    }

    @Test
    public void createUserTest(){
        // 1 Tries to see if creating a user works
        // 2 Logs out
        // 3 Tries to log in with newly made username (should be saved in database now)

        // 1
        logIn("TestUser","password123", false);

        // 2
        ViewInteraction goToHomeButton = Espresso.onView(ViewMatchers.withId(R.id.homeButton));
        goToHomeButton.perform(ViewActions.click());

        ViewInteraction logOutButton = Espresso.onView(ViewMatchers.withId(R.id.logOutButton));
        logOutButton.perform(ViewActions.click());

        // 3
        logIn("TestUser","password123", true);
    }

    @Test
    public void testFaultyPassword(){
        //Tests if TestUser1 can login with the same password as TestUser
        logIn("TestUser1","password123", true);

        ViewInteraction logGate = Espresso.onView(ViewMatchers.withId(R.id.logInGate));
        logGate.check(ViewAssertions.matches(ViewMatchers.withText("Incorrect password or username")));
    }

    @Test
    public void testUsernameTooShort(){
        //Tests to see if it forces longer usernames
        logIn("s","thisisalongstring",false);

        ViewInteraction logGate = Espresso.onView(ViewMatchers.withId(R.id.logInGate));
        logGate.check(ViewAssertions.matches(ViewMatchers.withText("Please input a username greater than 2 characters long")));
    }

    @Test
    public void testPasswordTooShort(){
        //Tests if the password is too short
        logIn("connorconnorconnor","s",false);

        ViewInteraction logGate = Espresso.onView(ViewMatchers.withId(R.id.logInGate));
        logGate.check(ViewAssertions.matches(ViewMatchers.withText("Please input a password greater than 4 characters long")));
    }

    @Test
    public void testUsernameAlreadyTaken(){
        //Tests if the username is already in the database
        logIn("sam","Genius", false);

        ViewInteraction logGate = Espresso.onView(ViewMatchers.withId(R.id.logInGate));
        logGate.check(ViewAssertions.matches(ViewMatchers.withText("Username already taken please try again")));
    }
}