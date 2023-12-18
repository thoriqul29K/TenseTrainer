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
        Button btnSimplePastQuiz = view.findViewById(R.id.btnSimplePastQuiz);
        Button btnSimplePresentQuiz = view.findViewById(R.id.btnSimplePresentQuiz);
        // Add similar lines for other quiz buttons

        // Set click listeners for each quiz button
        btnSimplePastQuiz.setOnClickListener(v -> navigateToSimplePastTenseQuiz());
        btnSimplePresentQuiz.setOnClickListener(v -> navigateToSimplePresentTenseQuiz());
        // Add similar lines for other quiz buttons

        return view;
    }

    private void navigateToSimplePastTenseQuiz() {
        Intent intent = new Intent(getActivity(), SimplePastTenseQuizActivity.class);
        startActivity(intent);
    }
    // Add similar methods for other quiz activities
    private void navigateToSimplePresentTenseQuiz() {
        Intent intent = new Intent(getActivity(), SimplePresentTenseQuizActivity.class);
        startActivity(intent);
    }
}
