package com.example.match_picture;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.GridView;

import com.example.match_picture.adapter.grid_adpter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class puzzel_play_activity extends AppCompatActivity {

    GridView gridView;



List<String> imglist = new ArrayList<>();
    ArrayList<String> imagearraylist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzel_play);
        String s=getIntent().getStringExtra("dificut");
        getSupportActionBar().setTitle(s);

        gridView=findViewById(R.id.gridview);
        AlertDialog.Builder builder=new AlertDialog.Builder(puzzel_play_activity.this);
        builder.setTitle("TIME:"+s);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();




        String imagess[];
        try {
            imagess= getAssets().list("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        imagearraylist =new ArrayList<String>(Arrays.asList(imagess));


        imglist = imagearraylist.subList(0,6);
        imglist.addAll(imglist);
        Collections.shuffle(imglist);

        grid_adpter grid_adpter = new grid_adpter(puzzel_play_activity.this, imglist);
        gridView.setNumColumns(3);
        gridView.setAdapter(grid_adpter);


    }


}