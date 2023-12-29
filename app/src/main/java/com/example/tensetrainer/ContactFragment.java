package com.example.tensetrainer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class ContactFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        // Handling Whatsapp button click
        ImageButton BtcontactWa = view.findViewById(R.id.BtcontactWa);
        TextView TextWa = view.findViewById(R.id.TextWa);

        View.OnClickListener whatsappClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String whatsappUrl = "https://wa.me/6282377126009";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(whatsappUrl));
                startActivity(intent);
            }
        };

        BtcontactWa.setOnClickListener(whatsappClickListener);
        TextWa.setOnClickListener(whatsappClickListener);

        ImageButton BtcontactEmail = view.findViewById(R.id.Btcontactemail);
        TextView TextEmail = view.findViewById(R.id.TextEmail);

        View.OnClickListener emailClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = "abdurahmanrizki240@gmail.com";
                composeEmail(emailAddress);
            }
        };

        BtcontactEmail.setOnClickListener(emailClickListener);
        TextEmail.setOnClickListener(emailClickListener);

        return view;
    }

    private void composeEmail(String emailAddress) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + Uri.encode(emailAddress)));

        // Specify the package to ensure it opens in the Gmail app
        intent.setPackage("com.google.android.gm");

        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // If no email client is available, show a message to the user
            // You can replace this with a Toast or other error handling
            // For simplicity, we'll log to the console
            System.out.println("No email client installed");
        }
    }


}
