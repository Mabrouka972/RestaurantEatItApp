package com.example.homepc.restauranteatitapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderPage extends AppCompatActivity {

    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ListView listView = (ListView) findViewById(R.id.order_page);
        mydb = new DatabaseHelper(this);


        ArrayList<OrderClass> list = new ArrayList<OrderClass>();
        Cursor data = mydb.Get_OrderDetails();

        if (data.getCount() == 0) {


        } else {
            while (data.moveToNext()) {

                list.add(new OrderClass(data.getString(0),data.getString(1),data.getString(2),data.getString(3)));

            }
        }

        OrderAdapter adapter = new OrderAdapter(getApplicationContext(),list);
        listView.setAdapter(adapter);
    }
}





