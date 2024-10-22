package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.io.FileOutputStream;
import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (username.isEmpty() || password.isEmpty()) {
                    // Handle empty fields, show an error message
                    // You can display a Toast or a Snackbar here
                } else {
                    saveCredentials(username, password);
                    // Registration successful, navigate to login activity
                    finish(); // Finish the registration activity
                }
            }
        });
    }

    private void saveCredentials(String username, String password) {
        // Save user credentials to a text file
        try {
            FileOutputStream fileOutputStream = openFileOutput("credentials.txt", MODE_APPEND);
            String data = username + "," + password + "\n";
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
