package edu.vassar.cmpu203.vassarspotify.view;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.vassar.cmpu203.vassarspotify.databinding.FragmentLoginFragmentBinding;
import edu.vassar.cmpu203.vassarspotify.model.Profile;


public class LoginFragment extends Fragment implements ILoginFragment {

    FragmentLoginFragmentBinding binding;
    Listener listener;

    public LoginFragment(Listener listener){
        this.listener = listener;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.binding = FragmentLoginFragmentBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.binding.logInButton.setOnClickListener(view1 -> {
            Editable usernameE = LoginFragment.this.binding.username.getText();
            Editable passwordE = LoginFragment.this.binding.password.getText();

            LoginFragment.this.listener.LogIn(usernameE.toString(), passwordE.toString(), LoginFragment.this);
        });
        this.binding.createButton.setOnClickListener(view12 -> {
            boolean takenUsername = true;
            String usernameE = LoginFragment.this.binding.username.getText().toString();
            String passwordE = LoginFragment.this.binding.password.getText().toString();

            if( usernameE.length() < 3){
                LoginFragment.this.binding.logInGate.setText("Please input a username greater than 2 characters long"); //...and maybe get a brain for christmas");
            }else if (passwordE.length() <= 5){
                LoginFragment.this.binding.logInGate.setText("Please input a password greater than 4 characters long");
            }else{
                //Now check if this username is already in the database
                List<Profile> profiles = LoginFragment.this.listener.getProfilesForCreateUser();

                for (Profile p: profiles){
                    if (p.getUsernameText().equalsIgnoreCase(usernameE)){
                        LoginFragment.this.binding.logInGate.setText("Username already taken please try again");
                        takenUsername = false;
                    }
                }
                if (takenUsername) {
                    LoginFragment.this.listener.CreateUser(usernameE, passwordE, LoginFragment.this);
                }
            }

        });
    }

    /**
     * Provides a way to show the user if their password didn't match the username
     *
     * If "worked" is false the user will see a message above the username input
     * that says "Incorrect password or username"
     * @param worked True if the password matches the username
     */
    @SuppressLint("SetTextI18n")
    public void successfullyLoggedIn(boolean worked){
        if (!worked) {
            LoginFragment.this.binding.logInGate.setText("Incorrect password or username");
        }
    }
    @Override
    public View getRootView() {
        return this.binding.getRoot();
    }
}