package com.example.match_picture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Handler;

public class puzzel_play_activity extends AppCompatActivity {

    GridView gridView;



List<String> imglist = new ArrayList<>();
    ArrayList<String> imagearraylist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzel_play);
        gridView=findViewById(R.id.gridview);



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