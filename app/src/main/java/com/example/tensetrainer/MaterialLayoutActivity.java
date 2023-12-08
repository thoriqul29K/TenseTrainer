package com.example.tensetrainer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MaterialLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the layout resource ID from the intent
        int layoutResourceId = getIntent().getIntExtra("layoutResourceId", 0);

        // Check if the layout resource ID is valid
        if (layoutResourceId != 0) {
            // Set the content view based on the selected tense's layout
            setContentView(layoutResourceId);

            // Find the back button by its ID
            ImageButton backButton = findViewById(R.id.backButton);
            // Set an OnClickListener to handle the button click
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Handle the back button click, e.g., go back to the previous screen or finish the activity
                    onBackPressed();
                }

            });
        } else {
            // Handle the case where the layout resource ID is not valid
            // You can show a toast or log a message
            finish(); // Close the activity if there's an issue
        }
    }
}
