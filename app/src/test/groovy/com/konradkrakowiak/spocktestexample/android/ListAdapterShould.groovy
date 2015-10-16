package com.konradkrakowiak.spocktestexample.android

import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import spock.lang.Specification
import spock.lang.Unroll

class ListAdapterShould extends Specification {

    def viewGolderProvider

    def listAdapter

    def layoutInflater

    def view

    def setup() {
        view = Mock(View, constructorArgs: [null])
        viewGolderProvider = Mock ViewHolderProvider
        layoutInflater = Mock(LayoutInflater, constructorArgs: [null])
        listAdapter = new ListAdapter(layoutInflater, viewGolderProvider);
    }


    def "create new view holder when createHolder method is called"() {
        when:
        listAdapter.onCreateViewHolder(new LinearLayout(null), 1);
        layoutInflater.inflate(_, _) >> view
        then:
        1 * viewGolderProvider.createListItemViewHolder(view)
        1 * layoutInflater.inflate(_, _)
    }

    def "bind view holder with right item when onBindViewHolder method is called"() {
        given:
        def object = Mock Object
        def list = Mock List
        listAdapter.objects = list
        def viewHolder = Mock(ListItemViewHolder, constructorArgs: [view])
        when:
        list.get(10) >> object
        listAdapter.onBindViewHolder(viewHolder, 10)
        then:
        1 * viewHolder.bindItem(object)
    }


    @Unroll
    def "return #count as item count of for list with the same size"() {
        given:
        def list = Mock List
        listAdapter.objects = list
        when:
        list.size() >> count
        then:
        listAdapter.getItemCount() == count
        where:
        count << (1..10)
    }
}
