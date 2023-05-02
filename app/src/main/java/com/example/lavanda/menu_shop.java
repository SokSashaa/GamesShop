package com.example.lavanda;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class menu_shop extends AppCompatActivity {

    ArrayList<CustomAdapter[]> menu1 = new ArrayList<CustomAdapter[]>();
    RecyclerView recyclerView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_shop);

        textView = (TextView) findViewById(R.id.textView8);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WindowManager.LayoutParams windowManagerParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                        WindowManager.LayoutParams.FLAG_DIM_BEHIND, PixelFormat.TRANSLUCENT);

                WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);

                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                View myView = inflater.inflate(R.layout.product, null);

                wm.addView(myView, windowManagerParams);
            }
        });


        CustomAdapter customAdapter = new CustomAdapter("buket", "Букет1", "1201");
        CustomAdapter customAdapter1 = new CustomAdapter("buket1", "Букет2", "1202");
        CustomAdapter customAdapter2 = new CustomAdapter("buket2", "Букет3", "1203");
        CustomAdapter[] customAdapters = new CustomAdapter[]{customAdapter, customAdapter1, customAdapter2};
        menu1.add(customAdapters);
        CustomAdapter customAdapter3 = new CustomAdapter("buket", "Букет4", "1204");
        CustomAdapter customAdapter4 = new CustomAdapter("buket1", "Букет5", "1205");
        CustomAdapter customAdapter5 = new CustomAdapter("buket2", "Букет6", "1206");
        CustomAdapter[] customAdapters1 = new CustomAdapter[]{customAdapter3, customAdapter4, customAdapter5};
        menu1.add(customAdapters1);


        recyclerView = (RecyclerView) findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CustomAdapterHolder customAdapterHolder = new CustomAdapterHolder(this, menu1);
        recyclerView.setAdapter(customAdapterHolder);


    }

    public void Send(View v) {
        switch (v.getId()) {
            case R.id.image1:
                int position = Integer.parseInt(v.getTag().toString());
                Intent intent = new Intent(menu_shop.this, product_item.class);
                intent.putExtra("name", menu1.get(position)[0].getNames());
                intent.putExtra("price", menu1.get(position)[0].getPrice());
                intent.putExtra("img", menu1.get(position)[0].getImageViews());
                startActivity(intent);
                break;
            case R.id.image2:
                int position1 = Integer.parseInt(v.getTag().toString());
                Intent intent1 = new Intent(menu_shop.this, product_item.class);
                intent1.putExtra("name", menu1.get(position1)[1].getNames());
                intent1.putExtra("price", menu1.get(position1)[1].getPrice());
                intent1.putExtra("img", menu1.get(position1)[1].getImageViews());
                startActivity(intent1);
                break;
            case R.id.image3:
                int position2 = Integer.parseInt(v.getTag().toString());
                Intent intent2 = new Intent(menu_shop.this, product_item.class);
                intent2.putExtra("name", menu1.get(position2)[2].getNames());
                intent2.putExtra("price", menu1.get(position2)[2].getPrice());
                intent2.putExtra("img", menu1.get(position2)[2].getImageViews());
                startActivity(intent2);
                break;

        }
    }
}

