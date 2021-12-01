package com.example.homepc.restauranteatitapp;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView = null;
    Toolbar toolbar = null;
    Button logout,cancel;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DatabaseHelper(this);


        Intent i = getIntent();
        String save1 = i.getStringExtra("Name_marker");



            Toast.makeText(getApplicationContext(),"Hello " + save1+ " , Welcome to Eat It Restaurant",Toast.LENGTH_SHORT).show();


        MainFragment fragment = new MainFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.Fragment_container, fragment);
        fragmentTransaction.commit();



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_fastfood) {
              FastFoodFragment fragment = new FastFoodFragment();
              android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
              fragmentTransaction.replace(R.id.Fragment_container, fragment);
              fragmentTransaction.commit();


        }else if (id == R.id.nav_seafood) {


            Fruit_de_mer_Fragment fragment = new Fruit_de_mer_Fragment();
           android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.Fragment_container, fragment);
            fragmentTransaction.commit();

        }

       else if (id == R.id.nav_traditional) {


            Nourriture_traditionnel_Fragment fragment = new Nourriture_traditionnel_Fragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
           fragmentTransaction.replace(R.id.Fragment_container, fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.nav_chinese) {


            Nourriture_chinoise_Fragment fragment = new Nourriture_chinoise_Fragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.Fragment_container, fragment);
            fragmentTransaction.commit();
        }
        else if(id == R.id.order_details_drawer ){

            Cursor check ;
            check = mydb.Get_OrderDetails() ;

            if(check!=null && check.getCount()>0)
            {      Intent intent = new Intent(getApplicationContext(), OrderPage.class);
                startActivity(intent);
            }
            else  {Toast.makeText(getApplicationContext(),"No details found because you didn't order something...",Toast.LENGTH_SHORT).show();}
        }
        else if(id == R.id.submit_order ){

            Cursor check ;
            check = mydb.Get_OrderDetails() ;

            if(check!=null && check.getCount()>0)
                {   Submit_Order fragment = new Submit_Order();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.Fragment_container, fragment);
                fragmentTransaction.commit();

            }
            else  {Toast.makeText(getApplicationContext(),"Sorry, You don't order anything...",Toast.LENGTH_SHORT).show();}
        }

        else if(id == R.id.log_out ){

            openDialog();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    public void openDialog() {

        final Dialog builder = new Dialog(this); // Context, this, etc.
        builder.setContentView(R.layout.dialogdesign);
        builder.setTitle(R.string.dialog_popup);
        builder.show();
        logout = (Button) builder.findViewById(R.id.dialog_ok);
        cancel = (Button) builder.findViewById(R.id.dialog_cancel);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mydb.delete_all();
                Toast.makeText(getApplicationContext(),"Hope you like our service, Have a good day !!!",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),LoginOptionsPage.class);
                startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"So you don't want to, Logout !!!",Toast.LENGTH_SHORT).show();
                builder.dismiss();
            }
        });

    }
}
