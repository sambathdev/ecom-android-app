package com.example.ecom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BlogListActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blog_list_activity);
    }
    public void onButtonClick2(View view){
        Intent intent = new Intent(this, BlogDetailActivity.class);
        startActivity(intent);
    }
}
