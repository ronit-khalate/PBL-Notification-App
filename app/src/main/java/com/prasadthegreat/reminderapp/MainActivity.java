package com.prasadthegreat.reminderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    FloatingActionButton mCreateRem;
    RecyclerView mRecyclerview;
    ArrayList<Model> dataholder=new ArrayList<Model>();
    myAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerview=(RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mCreateRem=(FloatingActionButton) findViewById(R.id.create_reminder);
        mCreateRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ReminderActivity.class);
                startActivity(intent);
            }
        });

        Cursor cursor=new dbManager(getApplicationContext()).readallreminders();
        while (cursor.moveToNext())
        {
            Model model=new Model(cursor.getString(1),cursor.getString(2),cursor.getString(3));
            dataholder.add(model);
        }

        adapter=new myAdapter(dataholder);
        mRecyclerview.setAdapter(adapter);

    }

    @Override
    public void onBackPressed()
    {
        finish();
        super.onBackPressed();

    }
}