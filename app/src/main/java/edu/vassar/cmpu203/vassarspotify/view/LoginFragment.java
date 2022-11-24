package edu.vassar.cmpu203.vassarspotify.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.vassarspotify.databinding.FragmentLoginFragmentBinding;


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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.binding.logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable usernameE = LoginFragment.this.binding.username.getText();
                Editable passwordE = LoginFragment.this.binding.password.getText();

                LoginFragment.this.listener.LogIn(usernameE.toString(), passwordE.toString(), LoginFragment.this);
            }
        });
        this.binding.createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable usernameE = LoginFragment.this.binding.username.getText();
                Editable passwordE = LoginFragment.this.binding.password.getText();

                LoginFragment.this.listener.CreateUser(usernameE.toString(), passwordE.toString(), LoginFragment.this);
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