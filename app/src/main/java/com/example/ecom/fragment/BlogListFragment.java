package com.example.ecom.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecom.BottomNavActivity;
import com.example.ecom.R;
import com.example.ecom.blogAdapter.Blog;
import com.example.ecom.blogAdapter.BlogsAdapter;


public class BlogListFragment extends Fragment {
    private String name;
    private Blog[] blogs;
    public BlogListFragment(String name, Blog[] blogs) {
        this.name = name;
        this.blogs = blogs;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_blog_list, container, false);
        TextView textView = fragmentView.findViewById(R.id.gogo);
        textView.setText("All Blogs");

        RecyclerView recyclerView = fragmentView.findViewById(R.id.recycler_view_blog_fragment);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        BlogsAdapter adapter = new BlogsAdapter(blogs);
        recyclerView.setAdapter(adapter);

        return fragmentView;
    }
}
