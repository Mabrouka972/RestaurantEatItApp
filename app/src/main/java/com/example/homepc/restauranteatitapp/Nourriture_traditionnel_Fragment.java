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
public class Nourriture_traditionnel_Fragment extends Fragment {


    public Nourriture_traditionnel_Fragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_traditional, container, false);

        ArrayList<Nourriture_Traditonnel_Class> trad_food = new ArrayList<Nourriture_Traditonnel_Class>();
        trad_food.add(new Nourriture_Traditonnel_Class("Karahi", "7 dt", R.drawable.karahi,"0"));
        trad_food.add(new Nourriture_Traditonnel_Class("Biryani", "8 dt", R.drawable.biryani,"0"));
        trad_food.add(new Nourriture_Traditonnel_Class("Malai Boti", "6 dt", R.drawable.malaiboti,"0"));
        trad_food.add(new Nourriture_Traditonnel_Class("Seekh Kabab", "9 dt", R.drawable.kabab,"0"));
        trad_food.add(new Nourriture_Traditonnel_Class("Tikka", "8 dt", R.drawable.tikka,"0"));
        trad_food.add(new Nourriture_Traditonnel_Class("Sajji", "8 dt", R.drawable.sajjione,"0"));

        Nourriture_traditionnel_Adapter tradfoodadapter = new Nourriture_traditionnel_Adapter(getActivity(),trad_food);

        ListView listView = (ListView) view.findViewById(R.id.listview_traditional);
        listView.setAdapter(tradfoodadapter);

        return view;
    }

}
