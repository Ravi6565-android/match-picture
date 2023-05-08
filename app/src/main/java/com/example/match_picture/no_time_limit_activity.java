package com.example.match_picture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.match_picture.adapter.level_adapter;

import java.util.ArrayList;

public class no_time_limit_activity extends AppCompatActivity {
RecyclerView recyclerView;


ArrayList<String> levels= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_time_limit);
        fill_level();
        String s=getIntent().getStringExtra("dificulty");
        getSupportActionBar().setTitle(s);

        recyclerView=findViewById(R.id.recycler);
            level_adapter level_adapter= new level_adapter(no_time_limit_activity.this,levels,s);
            LinearLayoutManager manager= new LinearLayoutManager(no_time_limit_activity.this);
            manager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(level_adapter);




    }
    public void fill_level(){
        levels.add("LEVEL 1");
        levels.add("LEVEL 2");
        levels.add("LEVEL 3");
        levels.add("LEVEL 4");
        levels.add("LEVEL 5");
        levels.add("LEVEL 6");
        levels.add("LEVEL 7");
        levels.add("LEVEL 8");
        levels.add("LEVEL 9");
        levels.add("LEVEL 10");
        levels.add("LEVEL 11");
        levels.add("LEVEL 12");
        levels.add("LEVEL 13");
        levels.add("LEVEL 14");
        levels.add("LEVEL 15");
    }
}