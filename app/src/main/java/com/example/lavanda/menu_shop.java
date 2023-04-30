package com.example.lavanda;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class menu_shop extends AppCompatActivity {

    ArrayList<PrAdapter> menu = new ArrayList<PrAdapter>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_shop);



        String[] names,price,img;
        names = new String[] {"Букет1","Букет2","Букет3"};
        price = new String[] {"1200 р.1","1200 р.2","1200 р.3"};
        img = new String[] {"buket","buket1","buket2"};
        menu.add(new PrAdapter(img,names,price));
        menu.add(new PrAdapter(img,names,price));
        menu.add(new PrAdapter(img,names,price));
        menu.add(new PrAdapter(img,names,price));

         recyclerView = (RecyclerView)findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // StateAdapter stateAdapter = new StateAdapter(this,menu);
          PrAdapterHolder prAdapterHolder = new PrAdapterHolder(this,menu);
        recyclerView.setAdapter(prAdapterHolder);



    }


}
