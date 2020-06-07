package com.example.ecom;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecom.emailAdapter.Email;
import com.example.ecom.emailAdapter.EmailsAdapter;

public class EmailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emails);

        // Make a reference to the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // create and set layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);


        Email[] emails = loadEmails();
        // create and set an adapter
        EmailsAdapter adapter = new EmailsAdapter(emails);

        recyclerView.setAdapter(adapter);

    }

    private Email[] loadEmails(){
        // temp data
        Email email1 = new Email();
        email1.setSender("Sok Sao");
        email1.setSubject("Hello");
        email1.setBody("How Are you");

        Email email2 = new Email();
        email2.setSender("Sam Kun");
        email2.setSubject("Hello bro bath");
        email2.setBody("How Are you fine thank me!");
        Email[] emails = new Email[]{email1, email2};

        return emails;
    }


}
