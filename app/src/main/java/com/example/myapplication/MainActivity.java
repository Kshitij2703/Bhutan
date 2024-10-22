package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button bookButton;
    private Button expenseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the "Book" button
        bookButton = findViewById(R.id.bookButton);
        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click event for booking
                // Start the PlaceDetailsActivity
                Intent intent = new Intent(MainActivity.this, PlaceDetailsActivity.class);
                startActivity(intent);
            }
        });

        // Initialize the "Expense" button
        expenseButton = findViewById(R.id.expense);
        expenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle button click event for expense
                // Navigate to PackageCalculatorActivity
                Intent intent = new Intent(MainActivity.this, PackageCalculatorActivity.class);
                startActivity(intent);
            }
        });
    }
}
