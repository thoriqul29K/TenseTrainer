package com.example.tensetrainer;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SimplePastTenseQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_past_tense_quiz);

        // You can initialize views and handle quiz logic here
        // Example:
        // Button finishButton = findViewById(R.id.finishButton);
        // finishButton.setOnClickListener(view -> calculateScore());
        ImageButton backButton = findViewById(R.id.backButton);




        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the back button click, e.g., go back to the previous screen or finish the activity
                onBackPressed();
            }

        });
    }

    // You can add additional methods for quiz logic as needed
    // Example:
    // private void calculateScore() {
    //     // Calculate the score based on user's answers
    // }

}
