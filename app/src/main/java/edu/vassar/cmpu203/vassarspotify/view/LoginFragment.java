package edu.vassar.cmpu203.vassarspotify.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

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
                String username = usernameE.toString();
                Editable passwordE = LoginFragment.this.binding.password.getText();
                String password = passwordE.toString();

                LoginFragment.this.listener.LogIn(username, password, LoginFragment.this);
            }
        });
        this.binding.createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable usernameE = LoginFragment.this.binding.username.getText();
                String username = usernameE.toString();
                Editable passwordE = LoginFragment.this.binding.password.getText();
                String password = passwordE.toString();

                LoginFragment.this.listener.CreateUser(username, password, LoginFragment.this);
            }
        });
    }

    public void successfullyLoggedIn(boolean worked){
        if (!worked) {
            LoginFragment.this.binding.logInGate.setText("Incorrect password or username");
            //Snackbar.make(getView(), "Login incorrect", Snackbar.LENGTH_INDEFINITE).show();
        //MainView.displayFragment(new SearchFragment(this),true, "search");
        }

    }
    @Override
    public View getRootView() {
        return this.binding.getRoot();
    }
}