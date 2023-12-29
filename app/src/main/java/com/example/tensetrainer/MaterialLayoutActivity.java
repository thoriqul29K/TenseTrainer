package com.example.tensetrainer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

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

            // Set an OnClickListener to handle the back button click
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Explicit Intent to go directly to MainMenuActivity
                    Intent intent = new Intent(MaterialLayoutActivity.this, MainMenuActivity.class);
                    finishAffinity(); // Optional: finish current activity if you don't want to go back to it
                    startActivity(intent);
                }
            });

            // Find the "ContinueToNextMaterial" button by its ID
            Button continueButton = findViewById(R.id.Continuetonextmaterial);

            // Set an OnClickListener to handle the button click
            if (continueButton != null) {
                continueButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Handle the button click to navigate to the next material
                        navigateToNextMaterial(layoutResourceId);
                    }
                });
            } else {

            }
        } else {
            finish();
        }
    }

    private void navigateToNextMaterial(int currentLayoutResourceId) {
        int nextLayoutResourceId = 0;

        // Determine the next layout based on the current layout
        if (currentLayoutResourceId == R.layout.mspt) {
            nextLayoutResourceId = R.layout.msprt;
        } else if (currentLayoutResourceId == R.layout.msprt) {
            nextLayoutResourceId = R.layout.msft;
        } else if (currentLayoutResourceId == R.layout.msft) {
            nextLayoutResourceId = R.layout.mpct;
        } else if (currentLayoutResourceId == R.layout.mpct) {
            nextLayoutResourceId = R.layout.mprct;
        } else if (currentLayoutResourceId == R.layout.mprct) {
            nextLayoutResourceId = R.layout.mfct;
        } else if (currentLayoutResourceId == R.layout.mfct) {
            nextLayoutResourceId = R.layout.mppt;
        } else if (currentLayoutResourceId == R.layout.mppt) {
            nextLayoutResourceId = R.layout.mprpt;
        } else if (currentLayoutResourceId == R.layout.mprpt) {
            nextLayoutResourceId = R.layout.mfpt;
        }
        // Add more else-if statements for additional layouts

        // Create an intent to start a new activity with the next material's layout
        Intent intent = new Intent(this, MaterialLayoutActivity.class);
        intent.putExtra("layoutResourceId", nextLayoutResourceId);
        startActivity(intent);
    }

    public void onBackPressed() {
        // Finish the current activity (MainMenuActivity)
        super.onBackPressed();
    }
}
