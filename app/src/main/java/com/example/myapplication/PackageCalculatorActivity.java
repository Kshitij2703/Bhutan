package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;

public class PackageCalculatorActivity extends AppCompatActivity {

    private TextInputEditText numberOfDaysEditText;
    private Button calculateButton;
    private TextView packageCostTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_calculator);

        numberOfDaysEditText = findViewById(R.id.numberOfDaysEditText);
        calculateButton = findViewById(R.id.calculateButton);
        packageCostTextView = findViewById(R.id.packageCostTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePackageCost();
            }
        });
    }

    private void calculatePackageCost() {
        String numberOfDaysString = numberOfDaysEditText.getText().toString();
        if (!numberOfDaysString.isEmpty()) {
            int numberOfDays = Integer.parseInt(numberOfDaysString);
            // Assume a fixed cost per day, you can adjust this based on your requirements
            int dailyCost = 100; // Example daily cost in dollars
            int totalCost = numberOfDays * dailyCost;
            packageCostTextView.setText("Package Cost: $" + totalCost);

            // Display a Toast message with the calculated cost and number of days
            String toastMessage = "Traveler will need to spend $" + totalCost + " for staying in " + numberOfDays + " days.";
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
        } else {
            packageCostTextView.setText("Package Cost: $0");

            // Display a Toast message indicating that the number of days is not entered
            Toast.makeText(this, "Please enter the number of days.", Toast.LENGTH_SHORT).show();
        }
    }
}
