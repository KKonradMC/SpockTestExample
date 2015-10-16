package com.konradkrakowiak.spocktestexample.android;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.konradkrakowiak.spocktestexample.R;
import java.util.LinkedList;
import java.util.List;


public class ListAdapter extends RecyclerView.Adapter<ListItemViewHolder> {

    ViewHolderProvider viewHolderProvider;

    List<Object> objects;

    LayoutInflater layoutInflater;

    ListAdapter(LayoutInflater layoutInflater, ViewHolderProvider viewHolderProvider){
        this.viewHolderProvider = viewHolderProvider;
        this.layoutInflater = layoutInflater;
        objects = new LinkedList<>();
    }
    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return viewHolderProvider.createListItemViewHolder(layoutInflater.inflate(R.layout.view_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        holder.bindItem(objects.get(position));
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }
}
