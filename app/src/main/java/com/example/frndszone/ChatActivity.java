package com.example.frndszone;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

import de.hdodenhof.circleimageview.CircleImageView;


public class ChatActivity extends AppCompatActivity {
    CircleImageView profile_image;
    TextView username;

    TabLayout tabLayout;
    ViewPager viewPager;


    @SuppressLint("RestrictedApi")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        profile_image = (CircleImageView) findViewById(R.id.profile_img);
        username = (TextView) findViewById(R.id.appname);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        getTabs();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.Logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ChatActivity.this, LoginActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void getTabs() {
        final ViewPageAdapter viewPagerAdapter = new ViewPageAdapter((getSupportFragmentManager()));
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                viewPagerAdapter.addFragments(ChatFragment.getInstance(), "CHATS");
                viewPagerAdapter.addFragments(ContactsFragment.getInstance(), "CONTACTS");
                viewPager.setAdapter(viewPagerAdapter);
                tabLayout.setupWithViewPager(viewPager);
            }
        });
    }
}