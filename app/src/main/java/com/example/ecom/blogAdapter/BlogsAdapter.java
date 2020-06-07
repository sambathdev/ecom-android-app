package com.example.ecom.blogAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecom.R;
import com.example.ecom.emailAdapter.Email;
import com.example.ecom.emailAdapter.EmailViewHolder;

public class BlogsAdapter extends RecyclerView.Adapter<BlogViewHolder> {
    private  Blog[] blogs;
    public BlogsAdapter(Blog[] blogs) {
        this.blogs = blogs;
    }

    @NonNull
    @Override
    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.view_holder_blog, parent, false);
        BlogViewHolder viewHolder = new BlogViewHolder( itemView );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BlogViewHolder holder, int position) {
        Blog blog = blogs[position];
        holder.bind(blog);
    }

    @Override
    public int getItemCount() {
        return blogs.length;
    }
}
