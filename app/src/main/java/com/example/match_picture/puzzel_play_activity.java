package com.example.match_picture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class puzzel_play_activity extends AppCompatActivity {

    GridView gridView;

ArrayList<String> imgArr= new ArrayList<>();


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
        imgArr=new ArrayList<>(Arrays.asList(imagess));

        imgArr.subList(0,6);
        imgArr.addAll(imgArr);
        Collections.shuffle(imgArr);

        grid_adpter grid_adpter = new grid_adpter(puzzel_play_activity.this,imgArr);

        gridView.setAdapter(grid_adpter);

    }


}