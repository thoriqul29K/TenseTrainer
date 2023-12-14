package com.example.tensetrainer;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuizFragment extends Fragment {

    public QuizFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        // Find buttons by their IDs
        Button btnSimplePast = view.findViewById(R.id.btnSimplePast);
        Button btnSimplePresent = view.findViewById(R.id.btnSimplePresent);
        Button btnSimpleFuture = view.findViewById(R.id.btnSimpleFuture);
        Button btnPastContinuous = view.findViewById(R.id.btnPastContinuous);
        Button btnPresentContinuous = view.findViewById(R.id.btnPresentContinuous);
        Button btnFutureContinuous = view.findViewById(R.id.btnFutureContinuous);

        // Set click listeners for each button
        btnSimplePast.setOnClickListener(v -> navigateToQuizLayout("qspt"));
        btnSimplePresent.setOnClickListener(v -> navigateToQuizLayout("qsprt"));
        btnSimpleFuture.setOnClickListener(v -> navigateToQuizLayout("qsft"));
        btnPastContinuous.setOnClickListener(v -> navigateToQuizLayout("qpct"));
        btnPresentContinuous.setOnClickListener(v -> navigateToQuizLayout("qprct"));
        btnFutureContinuous.setOnClickListener(v -> navigateToQuizLayout("qfct"));

        return view;
    }

    private void navigateToQuizLayout(String tense) {
        // Construct the layout resource ID based on the tense name
        int layoutResourceId = getResources().getIdentifier(tense, "layout", getActivity().getPackageName());

        // Check if the layout resource exists
        if (layoutResourceId != 0) {
            // Create an intent to start a new activity with the selected tense's layout
            Intent intent = new Intent(getActivity(), QuizLayoutActivity.class);
            intent.putExtra("layoutResourceId", layoutResourceId);
            startActivity(intent);
        } else {
            // Handle the case where the layout resource doesn't exist
            // You can show a toast or log a message
        }
    }
}
