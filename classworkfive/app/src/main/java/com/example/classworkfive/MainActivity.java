package com.example.classworkfive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Items> myList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    Items item1 = new Items("Cookies" , 0.500 , R.drawable.cookies);
    Items item2 = new Items("Croissant" , 0.750 , R.drawable.croissant);
    Items item3 = new Items("Danish" , 1.00 , R.drawable.danish);

     myList.add(item1);
        myList.add(item2);
        myList.add(item3);


        RecyclerView recycler = findViewById(R.id.rv);
        recycler.setHasFixedSize(true);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);


        Adapter adapter = new Adapter(myList, this);
        recycler.setAdapter(adapter);

    }

}