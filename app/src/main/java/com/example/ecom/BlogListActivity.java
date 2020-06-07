package com.example.ecom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecom.blogAdapter.Blog;
import com.example.ecom.blogAdapter.BlogsAdapter;
import com.example.ecom.emailAdapter.Email;
import com.example.ecom.emailAdapter.EmailsAdapter;
import com.example.ecom.popularAdapter.PopsAdapter;
import com.example.ecom.popularAdapter.Popular;

public class BlogListActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blog_list_activity);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_blog);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Blog[] blogs = loadBlogs();

        BlogsAdapter adapter = new BlogsAdapter(blogs);

        recyclerView.setAdapter(adapter);

        // ---------------
        RecyclerView recyclerViewPop = findViewById(R.id.recycler_view_pop);

        RecyclerView.LayoutManager layoutManagerPop = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerViewPop.setLayoutManager(layoutManagerPop);

        Popular[] pops = loadPops();
        // create and set an adapter
        PopsAdapter adapterPop = new PopsAdapter(pops);

        recyclerViewPop.setAdapter(adapterPop);


    }

    private Blog[] loadBlogs(){
        // temp data
        Blog blog1 = new Blog();
        blog1.setTitle("Blog 1 title");
        blog1.setBody("i write blog today");
        blog1.setAuthor("Sambath");

        Blog blog2 = new Blog();
        blog2.setTitle("Blog 2 title");
        blog2.setBody("i write blog yesterday");
        blog2.setAuthor("Samnang");

        Blog blog3 = new Blog();
        blog3.setTitle("Blog 3 title");
        blog3.setBody("i write blog lastyear");
        blog3.setAuthor("lina");

        Blog blog4 = new Blog();
        blog4.setTitle("Blog 4 title");
        blog4.setBody("i write blog this year");
        blog4.setAuthor("yaro");

        Blog[] blogs = new Blog[]{blog1, blog2, blog3, blog4};

        return blogs;
    }
    private Popular[] loadPops(){
        // temp data
        Popular pop1 = new Popular();
        pop1.setTitle("Blog 1 title");
        pop1.setBody("i write blog today");
        pop1.setAuthor("Sambath");

        Popular pop2 = new Popular();
        pop2.setTitle("Blog 2 title");
        pop2.setBody("i write blog yesterday");
        pop2.setAuthor("hana");

        Popular pop3 = new Popular();
        pop3.setTitle("Blog 3 title");
        pop3.setBody("i write blog last year");
        pop3.setAuthor("hono");

        Popular[] pops = new Popular[]{pop1, pop2, pop3};

        return pops;
    }

    public void onButtonClick2(View view){
        Intent intent = new Intent(this, BlogDetailActivity.class);
        startActivity(intent);
    }
}
