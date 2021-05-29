package com.prasadthegreat.reminderapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myviewholder>
{
    ArrayList<Model> dataholder=new ArrayList<Model>();

    public myAdapter(ArrayList<Model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.single_reminder_file,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {
        holder.mTitle.setText(dataholder.get(position).getTitle());
        holder.mDate.setText(dataholder.get(position).getDate());
        holder.mTime.setText(dataholder.get(position).getTime());
    }

    @Override
    public int getItemCount()
    {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {

        TextView mTitle,mDate,mTime;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

            mTitle=(TextView)itemView.findViewById(R.id.txtTitle);
            mDate=(TextView)itemView.findViewById(R.id.txtDate);
            mTime=(TextView)itemView.findViewById(R.id.txtTime);
        }
    }
}
