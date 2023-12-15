package com.example.tensetrainer;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        // Retrieve user's score from the intent
        int userScore = getIntent().getIntExtra("userScore", 0);

        // Update UI elements based on the score
        TextView tvScore = findViewById(R.id.tvScore);
        tvScore.setText(userScore + "/10 questions answered correctly");

        // Calculate and display alphabetical score
        TextView tvAlphabeticalScore = findViewById(R.id.user2ndscore);
        String alphabeticalScore = calculateAlphabeticalScore(userScore);
        tvAlphabeticalScore.setText(alphabeticalScore);
    }

    private String calculateAlphabeticalScore(int userScore) {
        if (userScore >= 9) {
            return "A";
        } else if (userScore >= 7) {
            return "B";
        } else if (userScore >= 5) {
            return "C";
        } else {
            return "D";
        }
    }
}
