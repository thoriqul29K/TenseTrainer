package com.example.tensetrainer;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class QuizLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the layout resource ID from the intent
        int layoutResourceId = getIntent().getIntExtra("layoutResourceId", 0);

        // Check if the layout resource ID is valid
        if (layoutResourceId != 0) {
            // Set the content view based on the selected tense's layout
            setContentView(layoutResourceId);
        } else {
            // Handle the case where the layout resource ID is not valid
            // You can show a toast or log a message
            finish(); // Close the activity if there's an issue
        }
    }
}
