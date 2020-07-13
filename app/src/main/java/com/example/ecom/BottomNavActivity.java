package com.example.ecom;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ecom.blogAdapter.Blog;
import com.example.ecom.blogAdapter.BlogsAdapter;
import com.example.ecom.fragment.BlogListFragment;
import com.example.ecom.fragment.ProfileFragment;
import com.example.ecom.fragment.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecom.fragment.CategoryFragment;
import com.google.gson.Gson;

public class BottomNavActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    String name = "gegegege";
    Blog[] blogs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bottom_nav);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Bottom Nav Bar
        BottomNavigationView bottomNav = findViewById(R.id.bootom_nav);
        bottomNav.setOnNavigationItemSelectedListener(this);
        loadBlogs();
        // Fragment


        // adapter

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.mnu_blogs_fragment) {
            showFragment(new BlogListFragment(name, blogs));
            getSupportActionBar().setTitle("Blogs");

        } else if (item.getItemId() == R.id.mnu_categories_fragment) {
            showFragment(new CategoryFragment(name, blogs));
            getSupportActionBar().setTitle("Category");
        }
        else if (item.getItemId() == R.id.mnu_profile_fragment) {
            showFragment(new ProfileFragment());
            getSupportActionBar().setTitle("Profile");
        } else {
            showFragment(new SettingsFragment());
            getSupportActionBar().setTitle("Setting");
        }

        return true;
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.lyt_fragment_container, fragment);
        fragmentTransaction.commit();
    }

    private void loadBlogs(){
        String url = "http://www.json-generator.com/api/json/get/calvUBPigi?indent=2";
        StringRequest request = new StringRequest(
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        blogs = gson.fromJson(response, Blog[].class);
                        showFragment(new BlogListFragment("name", blogs));
                        getSupportActionBar().setTitle("Blogs");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        );
        Volley.newRequestQueue(this).add(request);
    }

}
