package com.example.ecom;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.drawee.view.SimpleDraweeView;

public class BlogDetailActivity extends AppCompatActivity {
    String title = "";
    String body = "";
    String author = "";
    String imgurl = "";
    private TextView txtTitle;
    private TextView txtBody;
    private TextView txtAuthor;
    private ImageView imgBlog;
    private EditText textinbox;
    private String textinboxstring;
    private Button btn;
    private TextView valueTV;
    private LinearLayout linearLayout;
    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            title = extras.getString("title");
            body = extras.getString("body");
            author = extras.getString("author");
            imgurl = extras.getString("imgurl");
        }
        setContentView(R.layout.blog_detail_activity);
        linearLayout =  (LinearLayout)findViewById(R.id.cmt_ss);
        valueTV = new TextView(this);

        txtTitle = this.findViewById(R.id.title_detail);
        txtBody = this.findViewById(R.id.body_detail);
        txtAuthor = this.findViewById(R.id.author_detail);
        imgBlog = this.findViewById(R.id.img_detail);
        txtTitle.setText(title);
        txtBody.setText(body);
        txtAuthor.setText(author);
        imgBlog.setImageURI(Uri.parse(imgurl));

        btn = findViewById(R.id.submitcmt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textinbox  = findViewById(R.id.plain_text_input);
                textinboxstring = textinbox.getEditableText().toString();
                Log.d("EditText---------", "textinboxstring"+textinboxstring);


                valueTV.setText(textinboxstring);
                valueTV.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                linearLayout.addView(valueTV);

            }
        });
    }

}
