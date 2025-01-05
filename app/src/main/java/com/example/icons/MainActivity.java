package com.example.icons;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare MediaPlayer objects for each sound
    private MediaPlayer doggySound, capybaraSound, catsSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // References to UI attachments
        ImageView doggy = findViewById(R.id.doggy);
        ImageView capybara = findViewById(R.id.capybara);
        ImageView cats = findViewById(R.id.cats);
        TextView message = findViewById(R.id.message);
        Button clearButton = findViewById(R.id.clearButton);

        // Don't show the clear button when nothing is selected
        clearButton.setVisibility(View.GONE);

        // Initialize MediaPlayer objects
        doggySound = MediaPlayer.create(this, R.raw.dog);
        capybaraSound = MediaPlayer.create(this, R.raw.capy);
        catsSound = MediaPlayer.create(this, R.raw.cat);

        // Click listener for doggy click (selection)
        doggy.setOnClickListener(v -> {
            message.setText("You clicked Doggy!");
            message.setTextColor(Color.rgb(139, 69, 19)); // Brown color for Doggy
            clearButton.setVisibility(View.VISIBLE); // Show the clear button

            // Play the doggy sound
            doggySound.start();
        });

        // Click listener for capybara click (selection)
        capybara.setOnClickListener(v -> {
            message.setText("You clicked Capybara!");
            message.setTextColor(Color.rgb(34, 139, 34)); // Green color for Capybara
            clearButton.setVisibility(View.VISIBLE); // Show the clear button

            // Play the capybara sound
            capybaraSound.start();
        });

        // Click listener for cats (selection)
        cats.setOnClickListener(v -> {
            message.setText("You clicked Cats!");
            message.setTextColor(Color.rgb(255, 165, 0)); // Orange color for Cats
            clearButton.setVisibility(View.VISIBLE); // Show the clear button

            // Play the cats sound
            catsSound.start();
        });

        // Click listener for clear button
        clearButton.setOnClickListener(v -> {
            message.setText("Touch any animal!");
            message.setTextColor(Color.BLACK); // Reset to default black color
            clearButton.setVisibility(View.GONE); // Hide the clear button

            // Stop all sounds if they are playing
            if (doggySound.isPlaying()) doggySound.pause();
            if (capybaraSound.isPlaying()) capybaraSound.pause();
            if (catsSound.isPlaying()) catsSound.pause();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release MediaPlayer resources when the activity is destroyed
        if (doggySound != null) {
            doggySound.release();
            doggySound = null;
        }
        if (capybaraSound != null) {
            capybaraSound.release();
            capybaraSound = null;
        }
        if (catsSound != null) {
            catsSound.release();
            catsSound = null;
        }
    }
}
