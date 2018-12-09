package com.dotify.music.dotify;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    //xml elements
    Button loginButton;
    Button newUserButton;

    EditText emailEdit;
    EditText passwordEdit;

    TextView forgotPassword;
    TextView errorMessage;

    //storage stuff
    String username;    //can also be an email
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_display);

        //link elements to xml
        loginButton = findViewById(R.id.loginButton);
        newUserButton = findViewById(R.id.newUserButton);
        emailEdit = findViewById(R.id.userIDBox);
        passwordEdit = findViewById(R.id.passwordBox);
        forgotPassword = findViewById(R.id.forgotPasswordLabel);
        errorMessage = findViewById(R.id.errorMessageLabel);

        errorMessage.setText("");

        loginButton.setOnClickListener((v) -> {
            //check if credentials are valid
            username = emailEdit.getText().toString();
            password = passwordEdit.getText().toString();
            //put password through a hash
            //check database for login combo

            //if valid, go to newsfeed
            //if not valid, display error text
            errorMessage.setText("I'm not finished yet!");
            setContentView(R.layout.activity_main);
            addStartupFragment();
            System.out.println("login button pushed!");
        });

        newUserButton.setOnClickListener((v) -> {
            //goto register page
            errorMessage.setText("Go to the Register page!");
            setContentView(R.layout.register_display);
            System.out.println("new user button pushed!");
        });

    }

    private void addStartupFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        NewsFeed newsFeed = new NewsFeed();
        transaction.add(R.id.main_feed_fragment, newsFeed);
        transaction.commit();
    }
}