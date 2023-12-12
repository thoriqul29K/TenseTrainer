package com.example.tensetrainer;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class ContactFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        ImageButton BtcontactWa = view.findViewById(R.id.BtcontactWa);
        TextView TextWa = view.findViewById(R.id.TextWa);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String formUrl = "https://wa.me/6282377126009?text=Waduh%20ada%20si%20ireng%20cuy.%20";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(formUrl));
                startActivity(intent);
            }
        };

        BtcontactWa.setOnClickListener(clickListener);
        TextWa.setOnClickListener(clickListener);

        return view;
    }
}