package com.example.tensetrainer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PresentContinuousTenseQuizActivity extends AppCompatActivity {

    private RadioGroup radioGroupQuestion1;
    private RadioGroup radioGroupQuestion2;
    private RadioGroup radioGroupQuestion3;
    private RadioGroup radioGroupQuestion4;
    private RadioGroup radioGroupQuestion5;
    private RadioGroup radioGroupQuestion6;
    private RadioGroup radioGroupQuestion7;
    private RadioGroup radioGroupQuestion8;
    private RadioGroup radioGroupQuestion9;
    private RadioGroup radioGroupQuestion10;

    // Add RadioGroups for other questions

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_continuous_tense_quiz);

        // Initialize RadioGroups for each question
        radioGroupQuestion1 = findViewById(R.id.rgQuestion1);
        radioGroupQuestion2 = findViewById(R.id.rgQuestion2);
        radioGroupQuestion3 = findViewById(R.id.rgQuestion3);
        radioGroupQuestion4 = findViewById(R.id.rgQuestion4);
        radioGroupQuestion5 = findViewById(R.id.rgQuestion5);
        radioGroupQuestion6 = findViewById(R.id.rgQuestion6);
        radioGroupQuestion7 = findViewById(R.id.rgQuestion7);
        radioGroupQuestion8 = findViewById(R.id.rgQuestion8);
        radioGroupQuestion9 = findViewById(R.id.rgQuestion9);
        radioGroupQuestion10 = findViewById(R.id.rgQuestion10);
        // Initialize RadioGroups for other questions

        // Set up the "Finish" button
        Button finishButton = findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateScore();
            }
        });

        // Set up the back button
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the back button click, e.g., go back to the previous screen or finish the activity
                onBackPressed();
            }
        });
    }

    private void calculateScore() {
        // Implement the logic to calculate the user's score based on selected answers
        int score = 0;

        // Question 1
        int selectedIdQuestion1 = radioGroupQuestion1.getCheckedRadioButtonId();
        if (selectedIdQuestion1 == R.id.answer1d) {
            score++;
        }

        // Question 2
        int selectedIdQuestion2 = radioGroupQuestion2.getCheckedRadioButtonId();
        if (selectedIdQuestion2 == R.id.answer2c) {
            score++;
        }

        // Question 3
        int selectedIdQuestion3 = radioGroupQuestion3.getCheckedRadioButtonId();
        if (selectedIdQuestion3 == R.id.answer3a) {
            score++;
        }

        // Question 4
        int selectedIdQuestion4 = radioGroupQuestion4.getCheckedRadioButtonId();
        if (selectedIdQuestion4 == R.id.answer4b) {
            score++;
        }

        // Question 5
        int selectedIdQuestion5 = radioGroupQuestion5.getCheckedRadioButtonId();
        if (selectedIdQuestion5 == R.id.answer5b) {
            score++;
        }

        // Question 6
        int selectedIdQuestion6 = radioGroupQuestion6.getCheckedRadioButtonId();
        if (selectedIdQuestion6 == R.id.answer6c) {
            score++;
        }

        // Question 7
        int selectedIdQuestion7 = radioGroupQuestion7.getCheckedRadioButtonId();
        if (selectedIdQuestion7 == R.id.answer7b) {
            score++;
        }

        // Question 8
        int selectedIdQuestion8 = radioGroupQuestion8.getCheckedRadioButtonId();
        if (selectedIdQuestion8 == R.id.answer8d) {
            score++;
        }

        // Question 9
        int selectedIdQuestion9 = radioGroupQuestion9.getCheckedRadioButtonId();
        if (selectedIdQuestion9 == R.id.answer9a) {
            score++;
        }

        // Question 10
        int selectedIdQuestion10 = radioGroupQuestion10.getCheckedRadioButtonId();
        if (selectedIdQuestion10 == R.id.answer10b) {
            score++;
        }

        // Implement similar logic for other questions

        // Display the score or start the ScoreActivity
        showScore(score);
    }

    private void showScore(int score) {
        // You can start the ScoreActivity and pass the user's score
        // Example:
        Intent intent = new Intent(PresentContinuousTenseQuizActivity.this, ScoreActivity.class);
        intent.putExtra("userScore", score);
        startActivity(intent);

    }
}
