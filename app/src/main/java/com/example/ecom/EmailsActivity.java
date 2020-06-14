package com.example.ecom;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ecom.emailAdapter.Email;
import com.example.ecom.emailAdapter.EmailsAdapter;
import com.google.gson.Gson;

public class EmailsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emails);

        // Make a reference to the RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progressbar);

        // create and set layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        isLoading(true);

        loadEmails();


    }
    private void isLoading(boolean state){
        if(state == true){
            recyclerView.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);
        }else{
            recyclerView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
        }

    }

    private void loadEmails(){

        String url = "http://www.json-generator.com/api/json/get/cpuRtnausy?indent=2";
        StringRequest request = new StringRequest(
            url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Gson gson = new Gson();
                    Email[] emails = gson.fromJson(response, Email[].class);

                    EmailsAdapter adapter = new EmailsAdapter(emails);
                    recyclerView.setAdapter(adapter);
                    isLoading(false);
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(EmailsActivity.this, "Something errors", Toast.LENGTH_LONG).show();
                    Log.d("piuecom", "load data error: "+error.getLocalizedMessage());
                }
            }
        );

        Volley.newRequestQueue(this).add(request);


    }


}
