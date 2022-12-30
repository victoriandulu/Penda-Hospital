package com.project.pendahospital.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.project.pendahospital.Adapters.ViewPagerAdapter;
import com.project.pendahospital.R;

public class DoctorsHomeActivity extends AppCompatActivity {
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_home);

        viewPager = findViewById(R.id.viewpager_home);
        tabLayout = findViewById(R.id.tabLayout_home);

        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.add(new AppointmentFragment(), "BOOK");
        viewPagerAdapter.add(new OrdersFragment(), "Order");
        viewPagerAdapter.add(new DoctorsFragment(), "Doc");
        viewPagerAdapter.add(new ProductsFragment(), "Prod");
        viewPagerAdapter.add(new TestsFragment(), "Test");
        viewPager.setAdapter(viewPagerAdapter);
    }
}