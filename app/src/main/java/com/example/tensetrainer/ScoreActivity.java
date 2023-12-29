package com.example.tensetrainer;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Button mainmenubutton = findViewById(R.id.mainmenubutton);

        mainmenubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScoreActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });

        // Retrieve user's score from the intent
        int userScore = getIntent().getIntExtra("userScore", 0);

        // Update UI elements based on the score
        TextView tvScore = findViewById(R.id.tvScore);
        tvScore.setText(userScore + "/10 questions answered correctly");

        // Calculate and display alphabetical score
        TextView tvAlphabeticalScore = findViewById(R.id.user2ndscore);
        String alphabeticalScore = calculateAlphabeticalScore(userScore);
        tvAlphabeticalScore.setText(alphabeticalScore);

        // Set text color based on alphabetical score
        int color = getColorForAlphabeticalScore(alphabeticalScore);
        tvAlphabeticalScore.setTextColor(color);

        TextView afterQuizTextView = findViewById(R.id.afterquiztv);
        if (userScore >= 7) {
            afterQuizTextView.setText("You passed the quiz with a high score\n good job!");
        } else {
            afterQuizTextView.setText("You got a low score?\n Don't lose hope!\n re-learn the material and try again!");
        }


    }

    private int getColorForAlphabeticalScore(String alphabeticalScore) {
        switch (alphabeticalScore) {
            case "A":
                return Color.parseColor("#4CAF50");
            case "B":
                return Color.parseColor("#673AB7");
            case "C":
                return Color.parseColor("#FF5722");
            case "D":
                return Color.parseColor("#FF0000");
            default:
                return Color.BLACK;
        }
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
