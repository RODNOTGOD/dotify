package com.dotify.music.dotify;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Login extends AppCompatActivity {

    //xml elements

    TextInputLayout usernameInput;
    TextInputLayout passwordInput;

    Button loginButton;

    TextView newUserButton;
    TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_display);

        //link elements to xml
        loginButton = findViewById(R.id.loginButton);
        newUserButton = findViewById(R.id.newUserButton);
        usernameInput = findViewById(R.id.userIDBox);
        passwordInput = findViewById(R.id.passwordBox);
        forgotPassword = findViewById(R.id.forgotPasswordLabel);

        loginButton.setOnClickListener((v) -> {
            if (credentialsAreValid()) {
                Log.i("Login", "User logged in");
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        });

        newUserButton.setOnClickListener((v) -> {
            Intent intent = new Intent(this, Register.class);
            startActivity(intent);
        });
    }

    public boolean credentialsAreValid() {
        String username = usernameInput.getEditText().getText().toString().trim();
        String password = passwordInput.getEditText().getText().toString().trim();

        if (username.isEmpty())
            usernameInput.setError("Field can't be empty");
        else if (!credentialExists(username, "isUnique.php?unique="))
            usernameInput.setError("User doesn't exist");
        else
            usernameInput.setError(null);

        if (password.isEmpty()) {
            passwordInput.setError("Field can't be empty");
        } else {
            passwordInput.setError(null);
        }

        if (loginUser(username, password)) {
            return true;
        } else {
            passwordInput.setError("Wrong password");
            return false;
        }
    }

    private boolean credentialExists(String uniqueStr, String url) {
        DatabaseRetriever retriever = new DatabaseRetriever();
        retriever.execute("GET", url + uniqueStr.toLowerCase());
        JSONArray data;
        try {
            data = retriever.get(1000, TimeUnit.MILLISECONDS);
            if (data == null) {
                Toast.makeText(this, "Failed to connect to server", Toast.LENGTH_SHORT).show();
                return false;
            }
            JSONObject object = data.getJSONObject(0);
            boolean hasRows = object.getBoolean("exists");
            return !hasRows;
        } catch (ExecutionException | InterruptedException | TimeoutException | JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean loginUser(String username, String password) {
        DatabaseRetriever retriever = new DatabaseRetriever();
        retriever.execute("GET", "loginUser.php?username=" + username + "&password=" + password);
        JSONArray data;
        try {
            data = retriever.get(2000, TimeUnit.MILLISECONDS);
            if (data == null) {
                Toast.makeText(this, "Failed to connect to server", Toast.LENGTH_SHORT).show();
                return false;
            }
            JSONObject object = data.getJSONObject(0);
            return object.getBoolean("login");
        } catch (ExecutionException | InterruptedException | TimeoutException | JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
