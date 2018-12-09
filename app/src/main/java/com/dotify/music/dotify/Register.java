package com.dotify.music.dotify;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    //xml elements
    Button registerButton;

    EditText firstNameEdit;
    EditText lastNameEdit;
    EditText usernameEdit;
    EditText emailEdit;
    EditText passwordEdit;
    EditText password2Edit;

    //storage stuff
    String firstName;
    String lastName;
    String email;
    String username;    //can also be an email
    String password;
    String password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_display);

        //link elements to xml
        registerButton = findViewById(R.id.registerButton);
        firstNameEdit = findViewById(R.id.firstNameBox);
        lastNameEdit = findViewById(R.id.lastNameBox);
        usernameEdit = findViewById(R.id.usernameBox);
        emailEdit = findViewById(R.id.emailBox);
        passwordEdit = findViewById(R.id.passwordBox);
        password2Edit = findViewById(R.id.verifyPasswordBox);


        registerButton.setOnClickListener((v) -> {
            //check if all inputs are valid
            //check if username or email is already taken
            //if taken, display error message
            //otherwise, create user and go to newsfeed
            System.out.println("Register Button Clicked!");
            setContentView(R.layout.activity_main);
        });
    }
}
