package com.adib.foodwhiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//activity that displays the restaurant menu when an NFC tag is detected
public class RestaurantMenu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private TextView restaurantName;
    private Button exit;
    private Button cart;

    private List<ListItem> listItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //sets the parent layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_menu);

        recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        restaurantName = findViewById(R.id.restaurantName);
        exit = findViewById(R.id.exit);
        cart = findViewById(R.id.cartIcon);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        listItems = new ArrayList<>();

        //function to retrieve restaurant whose NFC tag is detected
        retrieveRestaurant();


     

        //button to view current items in cart
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RestaurantMenu.this, Cart.class);
                startActivity(intent);
            }
        });

    }


    //function that retrieves the restaurant. Takes NFC id as the parameter, backend returns the restaurant record that matches. Restaurant name set on top of layout.
    private void retrieveRestaurant() {

        Intent intent = getIntent();

    }}