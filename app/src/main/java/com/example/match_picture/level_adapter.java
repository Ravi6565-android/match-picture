package com.example.match_picture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class level_adapter extends RecyclerView.Adapter<level_adapter.view_holder> {
    Context context;
    ArrayList<String> levels;

    public level_adapter(Context context, ArrayList<String> levels) {
        this.context=context;
        this.levels=levels;
    }

    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_for_recycler,parent,false);
        view_holder holder= new view_holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull view_holder holder, int position) {
        holder.textView.setText(levels.get(position));
    }

    @Override
    public int getItemCount() {
        return levels.size();
    }
    public class view_holder extends RecyclerView.ViewHolder {

        TextView textView;
        public view_holder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.item_text);
        }
    }
}