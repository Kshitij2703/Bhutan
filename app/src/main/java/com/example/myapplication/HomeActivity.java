package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class HomeActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton, registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (authenticateUser(username, password)) {
                    // Successful login, navigate to MainActivity
                    startActivity(new Intent(HomeActivity.this, MainActivity.class));
                    finish(); // Finish the HomeActivity to prevent coming back to it when pressing back button in MainActivity
                } else {
                    // Invalid credentials, show an error message
                    Toast.makeText(HomeActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (!username.isEmpty() && !password.isEmpty()) {
                    saveCredentials(username, password);
                    // Registration successful, show a success message
                    Toast.makeText(HomeActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                } else {
                    // Invalid input, show an error message
                    Toast.makeText(HomeActivity.this, "Username and password cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean authenticateUser(String username, String password) {
        // Read user credentials from the text file and validate
        File file = new File(getFilesDir(), "credentials.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    reader.close();
                    return true; // User found, authentication successful
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // User not found or invalid credentials
    }

    private void saveCredentials(String username, String password) {
        // Save user credentials to a text file
        try {
            File file = new File(getFilesDir(), "credentials.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            String data = username + "," + password + "\n";
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
