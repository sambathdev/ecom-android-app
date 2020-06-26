package com.example.ecom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ecom.blogAdapter.Blog;
import com.example.ecom.blogAdapter.BlogsAdapter;
import com.example.ecom.emailAdapter.Email;
import com.example.ecom.emailAdapter.EmailsAdapter;
import com.example.ecom.popularAdapter.PopsAdapter;
import com.example.ecom.popularAdapter.Popular;
import com.google.gson.Gson;

public class BlogListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView recyclerViewPop;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blog_list_activity);

        recyclerView = findViewById(R.id.recycler_view_blog);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        loadBlogs();
        // ---------------
        recyclerViewPop = findViewById(R.id.recycler_view_pop);
        RecyclerView.LayoutManager layoutManagerPop = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerViewPop.setLayoutManager(layoutManagerPop);

        loadPops();

    }

    private void loadBlogs(){
        String url = "http://www.json-generator.com/api/json/get/calvUBPigi?indent=2";
        StringRequest request = new StringRequest(
            url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Gson gson = new Gson();
                    Blog[] blogs = gson.fromJson(response, Blog[].class);

                    BlogsAdapter adapter = new BlogsAdapter(blogs);
                    recyclerView.setAdapter(adapter);
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(BlogListActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
            }
        );
        Volley.newRequestQueue(this).add(request);
    }
    private void loadPops(){
       String url = "http://www.json-generator.com/api/json/get/caCJLLqgrS?indent=2";
       StringRequest request = new StringRequest(
           url,
           new Response.Listener<String>() {
               @Override
               public void onResponse(String response) {
                   Gson gson = new Gson();
                   Popular[] pops = gson.fromJson(response, Popular[].class);

                   PopsAdapter adapterPop = new PopsAdapter(pops);
                   recyclerViewPop.setAdapter(adapterPop);
               }
           },
           new Response.ErrorListener() {
               @Override
               public void onErrorResponse(VolleyError error) {
                   Toast.makeText(BlogListActivity.this, "Error", Toast.LENGTH_LONG).show();
               }
           }
       );
       Volley.newRequestQueue(this).add(request);
    }

    public void onButtonClick2(View view){
        Intent intent = new Intent(this, BlogDetailActivity.class);
        startActivity(intent);
    }
}
