package com.example.lavanda;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class menu_shop extends AppCompatActivity {

    ArrayList<CustomAdapter[]> menu1 = new ArrayList<CustomAdapter[]>();
    RecyclerView recyclerView;
    TextView main;
    TextView category;
    TextView about_us;
    CustomAdapterHolder customAdapterHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_shop);

        int indexMenu = getIntent().getIntExtra("menu",-1);
        switch (indexMenu){
            case 0:
                initialInformationForFlowers();break;
            case 1:break;
            case 2:break;
            case 3:break;
        }





        recyclerView = (RecyclerView) findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customAdapterHolder = new CustomAdapterHolder(this, menu1);
        recyclerView.setAdapter(customAdapterHolder);

        about_us = (TextView) findViewById(R.id.textView5);
        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(menu_shop.this,about_us.class));
            }
        });

        main =(TextView) findViewById(R.id.textView);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(menu_shop.this,MainActivity.class));
            }
        });

        category = (TextView)findViewById(R.id.textView3);
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonShowPopupWindowClick(category);
            }
        });

    }

    private void initialInformationForFlowers()
    {
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

    }
    @Override
    protected void onResume() {

        super.onResume();
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
    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popupwindow,null);

        boolean focusable = true; // lets taps outside the popup also dismiss it

        final PopupWindow popupWindow = new PopupWindow(popupView, 700, 720, focusable); // 600 460

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken



        TextView flowers = (TextView)popupView.findViewById(R.id.textView13);
        flowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                menu1.clear();
                //заполнение из бд
                recyclerView.setAdapter(customAdapterHolder);

            }
        });
        TextView forWedding = (TextView)popupView.findViewById(R.id.textView14);
        forWedding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
               // startActivity(new Intent(MainActivity.this, menu_shop.class).putExtra("menu",1));
            }
        });
        TextView balls = (TextView)popupView.findViewById(R.id.textView15);
        balls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                //startActivity(new Intent(MainActivity.this, menu_shop.class).putExtra("menu",2));
            }
        });
        TextView toys = (TextView)popupView.findViewById(R.id.textView16);
        toys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                //startActivity(new Intent(MainActivity.this, menu_shop.class).putExtra("menu",3));
            }
        });

        int [] location = new int[2];
        category.getLocationInWindow(location);
        int x = location[0];
        int y = location[1];
        popupWindow.showAtLocation(view, Gravity.NO_GRAVITY, x-215, y-210);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
}

