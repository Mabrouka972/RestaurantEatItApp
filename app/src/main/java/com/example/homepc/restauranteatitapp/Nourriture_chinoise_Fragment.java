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


public class Nourriture_chinoise_Fragment extends Fragment {
    DatabaseHelper mydb;

    public Nourriture_chinoise_Fragment() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_chinoise, container, false);
        this.mydb = new DatabaseHelper(getContext());
        ArrayList<Nourriture_chinoise_Class> c_food = new ArrayList<Nourriture_chinoise_Class>();
        c_food.add(new Nourriture_chinoise_Class("Fried Rice", "11 dt", R.drawable.friedrice,"0"));
        c_food.add(new Nourriture_chinoise_Class("Sushi", "7 dt", R.drawable.sushi,"0"));
        c_food.add(new Nourriture_chinoise_Class("Haka Noodles", "8 dt", R.drawable.haka,"0"));
        c_food.add(new Nourriture_chinoise_Class("Corn Soup", "10 dt", R.drawable.soup,"0"));

        Nourriture_chinoise_Adapter cadapter = new Nourriture_chinoise_Adapter(getActivity(),c_food);


        ListView listView = (ListView) view.findViewById(R.id.listview_chinese);
        listView.setAdapter(cadapter);



        return view;
    }





}
