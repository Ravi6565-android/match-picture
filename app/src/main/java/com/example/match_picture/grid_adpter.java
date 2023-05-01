package com.example.match_picture;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class grid_adpter extends BaseAdapter {

    Context context;
    ArrayList<String> imgArr;
    public grid_adpter(Context context, ArrayList<String> imgArr)
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
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.item_for_grid,parent,false);
        ImageView imageView;
        imageView=convertView.findViewById(R.id.image_item);

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
