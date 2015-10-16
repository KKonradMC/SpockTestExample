package com.konradkrakowiak.spocktestexample.android;

import android.view.View;

/**
 * Created by Konrad on 16/10/15.
 */
public class ViewHolderProvider {

    ListItemViewHolder createListItemViewHolder(View view){
        return new ListItemViewHolder(view);
    }
}
