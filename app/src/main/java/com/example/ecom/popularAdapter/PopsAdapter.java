package com.example.ecom.popularAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecom.R;
import com.example.ecom.blogAdapter.Blog;
import com.example.ecom.blogAdapter.BlogViewHolder;

public class PopsAdapter extends RecyclerView.Adapter<PopViewHolder> {
    private Popular[] pops;
    public PopsAdapter(Popular[] pops) {
        this.pops = pops;
    }

    @NonNull
    @Override
    public PopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.view_holder_pop, parent, false);
        PopViewHolder viewHolder = new PopViewHolder( itemView );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PopViewHolder holder, int position) {
        Popular pop = pops[position];
        holder.bind(pop);
    }

    @Override
    public int getItemCount() {
        return pops.length;
    }
}
