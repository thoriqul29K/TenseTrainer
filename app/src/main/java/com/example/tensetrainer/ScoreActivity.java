package com.example.tensetrainer;

import android.content.Intent;
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

        // Set up the "afterquizbt" button based on the user's score
        Button afterQuizButton = findViewById(R.id.afterquizbt);

        if (alphabeticalScore.equals("C") || alphabeticalScore.equals("D")) {
            // If the user got a C or D, set up the button to go back to the material page
            afterQuizButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    navigateToMaterialPage();
                }
            });
        } else {
            // If the user got an A or B, set up the button to go to the next quiz
            afterQuizButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    navigateToNextQuiz();
                }
            });
        }
    }

    private void navigateToMaterialPage() {
        Intent intent = new Intent(ScoreActivity.this, MaterialLayoutActivity.class);
        startActivity(intent);
        finish();
    }

    private void navigateToNextQuiz() {
        int userScore = getIntent().getIntExtra("userScore", 0);
        String alphabeticalScore = calculateAlphabeticalScore(userScore);

        int nextQuizLayout = getNextQuizLayout(alphabeticalScore);

        Intent intent = new Intent(ScoreActivity.this, QuizLayoutActivity.class);
        intent.putExtra("layoutResourceId", nextQuizLayout);
        startActivity(intent);
        finish();
    }


    private int getNextQuizLayout(String alphabeticalScore) {
        switch (alphabeticalScore) {
            case "A":
                return R.layout.mfct; // Replace with the layout for the next quiz after A
             case "B":
    return R.layout.mfct;

            default:
                // Default case: return a fallback layout or handle accordingly
                return R.layout.activity_main_menu;
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
