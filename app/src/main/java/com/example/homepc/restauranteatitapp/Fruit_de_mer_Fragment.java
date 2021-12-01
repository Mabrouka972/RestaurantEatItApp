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
public class Fruit_de_mer_Fragment extends Fragment {


    public Fruit_de_mer_Fragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sea, container, false);

        ArrayList<Fruit_de_mer_Class> sea_food = new ArrayList<Fruit_de_mer_Class>();
        sea_food.add(new Fruit_de_mer_Class("Finger Fish", "9 dt", R.drawable.fingerfish,"0"));
        sea_food.add(new Fruit_de_mer_Class("Shrimp", "10 dt", R.drawable.shrimp,"0"));
        sea_food.add(new Fruit_de_mer_Class("Fried Fish", "8 dt", R.drawable.fishone,"0"));
        sea_food.add(new Fruit_de_mer_Class("Prawn Soup", "8 dt", R.drawable.prawnsoup,"0"));

        Fruit_de_mer_Adapter seaadapter = new Fruit_de_mer_Adapter(getActivity(),sea_food);

        ListView listView = (ListView) view.findViewById(R.id.listview_sea);
        listView.setAdapter(seaadapter);





        return view;
    }

}
