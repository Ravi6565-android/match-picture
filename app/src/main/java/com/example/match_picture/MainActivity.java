package com.example.match_picture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity implements View .OnClickListener{
TextView no_time_limit,normal,hard;
public static SharedPreferences preferences;
public static SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        preferences=getSharedPreferences("myPref",MODE_PRIVATE);
        editor=preferences.edit();

        int levelNo=preferences.getInt("levelNo",0);
        System.out.println("Level No="+levelNo);
    }
    public void init(){
        no_time_limit=findViewById(R.id.no_time_limit);
        normal=findViewById(R.id.NORMAL);
        hard= findViewById(R.id.HARD);

        no_time_limit.setOnClickListener(this);
        normal.setOnClickListener(this);
        hard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==no_time_limit.getId()){
            Intent intent=new Intent(MainActivity.this,no_time_limit_activity.class);
            intent.putExtra("dificulty",no_time_limit.getText().toString());
            startActivity(intent);
        } if(v.getId()==normal.getId()){
            Intent intent=new Intent(MainActivity.this,no_time_limit_activity.class);
            intent.putExtra("dificulty",normal.getText().toString());
            startActivity(intent);
        } if(v.getId()==hard.getId()){
            Intent intent=new Intent(MainActivity.this,no_time_limit_activity.class);
            intent.putExtra("dificulty",hard.getText().toString());
            startActivity(intent);
        }
    }
}