package com.example.ecom.blogAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecom.BlogDetailActivity;
import com.example.ecom.BottomNavActivity;
import com.example.ecom.R;
import com.example.ecom.emailAdapter.Email;
import com.facebook.drawee.view.SimpleDraweeView;

public class BlogViewHolder extends RecyclerView.ViewHolder {
    private TextView txtTitle;
    private TextView txtBody;
    private TextView txtAuthor;
    private SimpleDraweeView imgBlog;
    private LinearLayout blogrow;

    private String title;
    private String body;
    private String author;
    private String imgBlogstring;

    private Context context;
    public BlogViewHolder(@NonNull View itemView) {
        super(itemView);



        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BlogDetailActivity.class);
                context.startActivity(intent);
            }
        });

        context = itemView.getContext();




        txtTitle = itemView.findViewById(R.id.txt_title);
        txtBody = itemView.findViewById(R.id.txt_blog_body);
        txtAuthor = itemView.findViewById(R.id.txt_author);
        imgBlog = itemView.findViewById(R.id.img_blog);
        blogrow = itemView.findViewById(R.id.blogrow);
    }
    private void gg(){

    }
    public void bind(Blog blog){
        String shortBlog = "";
        if(blog.getBody().length() > 80){
            shortBlog = blog.getBody().substring(0,80)+"...";
        }else{
            shortBlog = blog.getBody()+"...";
        }
        title = blog.getTitle();
        body = blog.getBody();
        author = blog.getAuthor();
        imgBlogstring = blog.getBlogUrl();

        txtTitle.setText(blog.getTitle());
        txtBody.setText(shortBlog);
        txtAuthor.setText(blog.getAuthor());
        imgBlog.setImageURI(blog.getBlogUrl());
        blogrow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {


                // do action when clicked.....
                Intent intent = new Intent(context, BlogDetailActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("body", body);
                intent.putExtra("author", author);
                intent.putExtra("imgurl", imgBlogstring);
                context.startActivity(intent);
            }
        });
    }


    public void onCldgick(View view){

        Intent intent = new Intent(context, BlogDetailActivity.class);
        context.startActivity(intent);
    }


}
