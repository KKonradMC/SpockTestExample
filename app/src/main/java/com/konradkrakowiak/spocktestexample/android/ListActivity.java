package com.konradkrakowiak.spocktestexample.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import com.konradkrakowiak.spocktestexample.R;

public class ListActivity extends AppCompatActivity {

    RecyclerView list;

    ListAdapter listAdapter;

    ViewHolderProvider viewHolderProvider;

    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_list);
        list = (RecyclerView) findViewById(R.id.list);
        viewHolderProvider = new ViewHolderProvider();
        listAdapter = new ListAdapter(LayoutInflater.from(this), viewHolderProvider);
        linearLayoutManager = new LinearLayoutManager(this);
        prepareList();

    }

    void prepareList() {
        list.setLayoutManager(linearLayoutManager);
        list.setAdapter(listAdapter);
    }
}
