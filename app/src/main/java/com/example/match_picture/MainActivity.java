package com.example.match_picture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity implements View .OnClickListener{
TextView no_time_limit,normal,hard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    public void init(){
        no_time_limit=findViewById(R.id.no_time_limit);
        normal=findViewById(R.id.NORMAL);
        hard= findViewById(R.id.HARD);

        no_time_limit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==no_time_limit.getId()){
            Intent intent=new Intent(MainActivity.this,no_time_limit_activity.class);
            intent.putExtra("dificulty",no_time_limit.getText().toString());
            startActivity(intent);
        }
    }
}