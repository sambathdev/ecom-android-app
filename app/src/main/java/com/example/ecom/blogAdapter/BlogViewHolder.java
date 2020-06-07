package com.example.ecom.blogAdapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecom.R;
import com.example.ecom.emailAdapter.Email;

public class BlogViewHolder extends RecyclerView.ViewHolder {
    private TextView txtTitle;
    private TextView txtBody;
    private TextView txtAuthor;

    public BlogViewHolder(@NonNull View itemView) {
        super(itemView);
        txtTitle = itemView.findViewById(R.id.txt_title);
        txtBody = itemView.findViewById(R.id.txt_blog_body);
        txtAuthor = itemView.findViewById(R.id.txt_author);
    }
    public void bind(Blog blog){
        txtTitle.setText(blog.getTitle());
        txtBody.setText(blog.getBody());
        txtAuthor.setText(blog.getAuthor());
    }
}
