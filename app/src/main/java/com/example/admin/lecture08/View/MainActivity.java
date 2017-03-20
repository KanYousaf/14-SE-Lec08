package com.example.admin.lecture08.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.lecture08.Adapter.myOwnAdapter;
import com.example.admin.lecture08.Model.SeasonAccessorMutator;
import com.example.admin.lecture08.Model.SeasonData;
import com.example.admin.lecture08.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements myOwnAdapter.OnItemClickCallback {
    private myOwnAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList seasonAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RecyclerView steps:
        //1. Add Model (SeasonData: convert data into arraylist, SeasonAccessorMutator: set and get all required data)
        //2. Add Adapter (Requires ViewHolder: add widget IDs,other informations)

        recyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);
        //style in which you want recycler layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //convert static arraylist data into non-static form for click event
        seasonAL = (ArrayList) SeasonData.getSeasonData();

        adapter = new myOwnAdapter(MainActivity.this, seasonAL);
        //set adapter for recycler view
        recyclerView.setAdapter(adapter);
        //to move to next activity
        adapter.setItemClickCallback(this);
    }

    @Override
    public void onClick(int p) {
        SeasonAccessorMutator seasonAccessorMutator = (SeasonAccessorMutator) seasonAL.get(p);
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("season_name", seasonAccessorMutator.getSeasonName());
        startActivity(intent);
    }
}
