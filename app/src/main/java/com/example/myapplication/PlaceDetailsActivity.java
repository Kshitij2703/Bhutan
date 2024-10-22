package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PlaceDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        // Find the UI components
        ImageButton placeImageButton = findViewById(R.id.placeImageButton);
        TextView placeDescriptionTextView = findViewById(R.id.placeDescriptionTextView);

        ImageButton placeImageButton1 = findViewById(R.id.placeImageButton1);
        TextView placeDescriptionTextView1 = findViewById(R.id.placeDescriptionTextView1);

        ImageButton placeImageButton2 = findViewById(R.id.placeImageButton2);
        TextView placeDescriptionTextView2 = findViewById(R.id.placeDescriptionTextView2);

        ImageButton placeImageButton3 = findViewById(R.id.placeImageButton3);
        TextView placeDescriptionTextView3 = findViewById(R.id.placeDescriptionTextView3);

// Set click listener for the ImageButton (Taktsang Monastery)
        placeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taktsangDescription = "Taktsang Monastery, also known as Tiger's Nest, is a prominent Buddhist monastery " +
                        "perched on the edge of a cliff in the Paro Valley of Bhutan. It is a sacred site and a popular pilgrimage " +
                        "destination for tourists. The monastery offers breathtaking views of the surrounding mountains and valleys.";
                placeDescriptionTextView.setText(taktsangDescription);

                // Display a toast message when the user clicks on the "Taktsang Monastery" location
                Toast.makeText(PlaceDetailsActivity.this, "You selected Taktsang Monastery", Toast.LENGTH_SHORT).show();
            }
        });

// Set click listener for the ImageButton1 (Thimphu)
        placeImageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String thimphuDescription = "Thimphu is the capital and largest city of Bhutan. " +
                        "It is a cultural, economic, and political center of the country. " +
                        "Thimphu offers a unique blend of traditional Bhutanese culture and modern development. " +
                        "Visitors can explore monasteries, museums, and markets while enjoying the serene atmosphere.";
                placeDescriptionTextView1.setText(thimphuDescription);

                // Display a toast message when the user clicks on the "Thimphu" location
                Toast.makeText(PlaceDetailsActivity.this, "You selected Thimphu", Toast.LENGTH_SHORT).show();
            }
        });

// Set click listener for the ImageButton2 (Bumthang Valley)
        placeImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bumthangDescription = "Bumthang Valley is often considered the spiritual heartland of Bhutan. " +
                        "It is renowned for its beautiful landscapes, ancient monasteries, and traditional culture. " +
                        "Visitors can explore historical sites, experience local festivals, and enjoy the natural beauty of the valley.";
                placeDescriptionTextView2.setText(bumthangDescription);

                // Display a toast message when the user clicks on the "Bumthang Valley" location
                Toast.makeText(PlaceDetailsActivity.this, "You selected Bumthang Valley", Toast.LENGTH_SHORT).show();
            }
        });

// Set click listener for the ImageButton3 (Paro)
        placeImageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String paroDescription = "Paro is a picturesque town in Bhutan, known for its rich culture and heritage. " +
                        "It is home to the iconic Paro Taktsang (Tiger's Nest) monastery, one of the most famous " +
                        "monastic retreats in Bhutan. Paro also offers vibrant festivals, traditional architecture, " +
                        "and scenic beauty, making it a must-visit destination for travelers.";
                placeDescriptionTextView3.setText(paroDescription);

                // Display a toast message when the user clicks on the "Paro" location
                Toast.makeText(PlaceDetailsActivity.this, "You selected Paro", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
