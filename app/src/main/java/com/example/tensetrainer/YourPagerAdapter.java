package com.example.tensetrainer;

// YourPagerAdapter.java
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class YourPagerAdapter extends FragmentPagerAdapter {

    public YourPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // Return the fragment for the given position
        switch (position) {
            case 0:
                return new MaterialFragment();
            case 1:
                return new QuizFragment();
            case 2:
                return new ContactFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Number of fragments to be displayed
        return 3; // Assuming you have three fragments
    }
}
