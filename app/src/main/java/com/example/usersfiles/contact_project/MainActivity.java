package com.example.usersfiles.contact_project;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.usersfiles.contact_project.Models.MainData;
import com.example.usersfiles.contact_project.adapters.recycl_contact_adapter;

import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {
        RecyclerView recyclerView ;
        ArrayList<MainData> Data;
        recycl_contact_adapter adapter;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}
