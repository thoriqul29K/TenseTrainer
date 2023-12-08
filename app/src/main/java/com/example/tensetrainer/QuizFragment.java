package com.example.tensetrainer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuizFragment extends Fragment {

    // ... (other code)

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        Button btnSimplePast = view.findViewById(R.id.btnSimplePast);
        Button btnSimplePresent = view.findViewById(R.id.btnSimplePresent);
        Button btnSimpleFuture = view.findViewById(R.id.btnSimpleFuture);
        Button btnPastContinuous = view.findViewById(R.id.btnPastContinuous);
        Button btnPresentContinuous = view.findViewById(R.id.btnPresentContinuous);

        // Set click listener for btnSimplePast
       btnSimplePast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the Google Form URL in a browser
                String formUrl = "https://docs.google.com/forms/d/e/1FAIpQLScRq7D-fT2BZzAhRJ0mWlIMqhxtu59tOHxILR0PVPZH0JJOaA/viewform";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(formUrl));
                startActivity(intent);
            }

        });
        btnSimpleFuture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String formUrl = "https://chat.openai.com";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(formUrl));
                startActivity(intent);
            }

        });
        btnSimplePresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String formUrl = "https://poe.com";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(formUrl));
                startActivity(intent);
            }

        });
        btnPresentContinuous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String formUrl = "https://wa.me/6285832560838?text=Waduh%20ada%20si%20ireng%20cuy.%20";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(formUrl));
                startActivity(intent);
            }

        });



        // ... (set click listeners for other buttons if needed)

        return view;
    }
}
