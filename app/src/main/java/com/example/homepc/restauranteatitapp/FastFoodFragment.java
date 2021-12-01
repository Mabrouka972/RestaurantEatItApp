package com.example.homepc.restauranteatitapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FastFoodFragment extends Fragment {


    public FastFoodFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fast_food, container, false);

        ArrayList<FastfoodClass> fastfood = new ArrayList<FastfoodClass>();
        fastfood.add(new FastfoodClass("Beef Burger", "7 dt", R.drawable.beef,"0"));
        fastfood.add(new FastfoodClass("Chicken Burger", "7 dt", R.drawable.chicken,"0"));
        fastfood.add(new FastfoodClass("Zinger Burger", "8 dt", R.drawable.zinger,"0"));
        fastfood.add(new FastfoodClass("Fries", "6 dt", R.drawable.fries,"0"));
        fastfood.add(new FastfoodClass("Zinger Roll", "7 dt", R.drawable.roll,"0"));
        fastfood.add(new FastfoodClass("Club Sandwich", "8 dt", R.drawable.club,"0"));
        fastfood.add(new FastfoodClass("Chicken Wings", "7 dt", R.drawable.wings,"0"));
        fastfood.add(new FastfoodClass("Chicken Broast", "7 dt", R.drawable.broast,"0"));
        fastfood.add(new FastfoodClass("Chicken Nuggets", "6 dt ", R.drawable.nuggets,"0"));


        FastFoodAdapter fastfoodadapter = new FastFoodAdapter(getActivity(),fastfood);

        ListView listView = (ListView) view.findViewById(R.id.listview_fastfood);
        listView.setAdapter(fastfoodadapter);
        return view;

    }

}
