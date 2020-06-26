package com.example.ecom;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbarhome);
        setSupportActionBar(toolbar);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.mnu_opt_menu) {
            Toast.makeText(this, R.string.optmenu, Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.mnu_notifications){
            Toast.makeText(this, R.string.notification_opt, Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.mnu_version){
            Toast.makeText(this, R.string.version_opt, Toast.LENGTH_LONG).show();
        }else if (item.getItemId() == R.id.mnu_about_us){
            Toast.makeText(this, R.string.aboutus_opt, Toast.LENGTH_LONG).show();
        }

        return true;
    }
    //gugu

    public void seeTestLayout(View view){
        Intent intent = new Intent(this, BottomNavActivity.class);
        startActivity(intent);
    }

}
