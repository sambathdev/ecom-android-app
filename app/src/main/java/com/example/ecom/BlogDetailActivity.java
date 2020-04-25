package com.example.ecom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BlogDetailActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blog_detail_activity);
    }
    public void onButtonClick3(View view){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
}
