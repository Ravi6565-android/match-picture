package com.example.match_picture.adapter;

import static com.example.match_picture.MainActivity.editor;
import static com.example.match_picture.MainActivity.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.match_picture.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class grid_adpter extends BaseAdapter {

    Context context;
    int cnt=1,click1=0,click2=0;

    List<String> imgArr;
    View frist;

    Runnable runnable;
    private int counter=0;


    public grid_adpter(Context context, List<String> imgArr)
    {
        this.context=context;
        this.imgArr=imgArr;

    }

    @Override
    public int getCount() {
        return imgArr.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.item_for_grid,parent,false);
        ImageView imageView;
        RelativeLayout layout=convertView.findViewById(R.id.relative);
        View view=convertView.findViewById(R.id.image_item_view);
        imageView=convertView.findViewById(R.id.image_item);

        Handler handler=new Handler();
        int time=5000;
        runnable=new Runnable() {
            @Override
            public void run() {
                view.setVisibility(View.VISIBLE);
            }
        };
        handler.postAtTime(runnable,System.currentTimeMillis()+time);
        handler.postDelayed(runnable,time);


        layout.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                if (cnt==1)
                {
                    view.setVisibility(View.INVISIBLE);
                    click1=position;

                    frist=view;
                     cnt=3;
                    runnable = new Runnable() {
                        @Override
                        public void run() {
                            cnt=2;
                        }
                    };
                    handler.postDelayed(runnable,200);
                }
                if (cnt==2)
                {
                    view.setVisibility(View.INVISIBLE);
                    click2=position;
                    cnt=3;



                    if (imgArr.get(click1).equals(imgArr.get(click2)))
                    {
                        counter++;
                        if(counter==6)
                        {
                            int levelNo;
                            levelNo=preferences.getInt("levelNo",0);
                            editor.putString("levelwin","win");
                            editor.commit();
                            System.out.println("LevelWin");
                        }
                        runnable=new Runnable() {
                            @Override
                            public void run() {
                                cnt=1;
                            }
                        };
                        handler.postDelayed(runnable,200);
                    }
                    else {

                        runnable=new Runnable() {
                            @Override
                            public void run() {
                                view.setVisibility(View.VISIBLE);
                                frist.setVisibility(View.VISIBLE);
                                cnt=1;
                            }
                        };
                        handler.postDelayed(runnable,200);
                    }

                }

            }
        });

        InputStream inputstream=null;
        try
        {
            inputstream = context.getAssets().open(""+imgArr.get(position));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Drawable drawable = Drawable.createFromStream(inputstream, null);
        imageView.setImageDrawable(drawable);

        return convertView;
    }
}
