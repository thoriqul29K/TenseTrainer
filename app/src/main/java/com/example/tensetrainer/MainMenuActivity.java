package com.example.tensetrainer;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenuActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        viewPager = findViewById(R.id.view_pager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        YourPagerAdapter pagerAdapter = new YourPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(pagerAdapter);

        // Handle item selection in the BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_material) {
                viewPager.setCurrentItem(0, true);
                return true;
            } else if (itemId == R.id.nav_quiz) {
                viewPager.setCurrentItem(1, true);
                return true;
            } else if (itemId == R.id.nav_contact_feedback) {
                viewPager.setCurrentItem(2, true);
                return true;
            } else {
                return false;
            }
        });

        // Synchronize BottomNavigationView with ViewPager
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Not needed for synchronization
            }

            @Override
            public void onPageSelected(int position) {
                // Update the selected item in BottomNavigationView when the page is changed
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Not needed for synchronization
            }
        });
    }
}
