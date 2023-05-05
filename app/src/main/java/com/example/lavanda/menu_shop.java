package com.example.lavanda;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

   private ArrayList<CustomAdapter[]> menu1 = new ArrayList<CustomAdapter[]>();
    private RecyclerView recyclerView;
    private TextView main;
    private TextView category;
    private TextView about_us;
    private CustomAdapterHolder customAdapterHolder;
    private DBHelper dbHelper;
    private SQLiteDatabase database;
    private Integer indexMenu;
    private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_shop);

        dbHelper = new DBHelper(this);
        dbHelper.create_db();
        database = dbHelper.open();

        indexMenu = getIntent().getIntExtra("menu",-1);
        setInformationForList();


        recyclerView = (RecyclerView) findViewById(R.id.rec);
        // recyclerView.setNestedScrollingEnabled(false);
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
                finish();
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
                setInformationForList();
                recyclerView.setAdapter(customAdapterHolder);

            }
        });
        TextView forWedding = (TextView)popupView.findViewById(R.id.textView14);
        forWedding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
              indexMenu=1;
              setInformationForList();
                recyclerView.setAdapter(customAdapterHolder);
            }
        });
        TextView balls = (TextView)popupView.findViewById(R.id.textView15);
        balls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                indexMenu=2;
                setInformationForList();
                recyclerView.setAdapter(customAdapterHolder);
            }
        });
        TextView toys = (TextView)popupView.findViewById(R.id.textView16);
        toys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                indexMenu=3;
                setInformationForList();
                recyclerView.setAdapter(customAdapterHolder);
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
    private void setInformationForList()
    {
        menu1.clear();
        
        String selection = "id_category = ?";
        try{
            CustomAdapter[] customAdapters = new CustomAdapter[3];
            int index = 0;


            cursor = database.query(DBHelper.TABLE_CONTACT,null,selection,new String[] {indexMenu.toString()},null,null,null);


            if(cursor.moveToFirst()){
                int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                int priceIndex = cursor.getColumnIndex(DBHelper.KEY_PRICE);
                int imgIndex = cursor.getColumnIndex(DBHelper.KEY_IMG);
                do{
                    if(index!=3)
                    {
                        String nameMenu = cursor.getString(nameIndex);
                        String priceMenu = cursor.getString(priceIndex);
                        String imgMenu = cursor.getString(imgIndex);
                        CustomAdapter customAdapter = new CustomAdapter(imgMenu,nameMenu,priceMenu);
                        customAdapters[index] = customAdapter;
                        index++;
                    }
                    if (index==3)
                    {
                        index=0;
                        menu1.add(customAdapters);
                        customAdapters=new CustomAdapter[3];
                    }

                }
                while(cursor.moveToNext());
                if(index!=0)
                {
                    for(int i=index;i<customAdapters.length;i++)
                    {
                        CustomAdapter customAdapter1 = new CustomAdapter("","","");
                        customAdapters[i]=customAdapter1;

                    }
                    menu1.add(customAdapters);
                }


            }
            cursor.close();
        }
        catch (Exception e){Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();}
    }
}

