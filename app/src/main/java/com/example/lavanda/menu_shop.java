package com.example.lavanda;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class menu_shop extends AppCompatActivity {

   private ArrayList<CustomAdapterForCat> categories = new ArrayList<CustomAdapterForCat>();
    private RecyclerView recyclerView;
    private TextView main;
    private TextView about_us;
    private CustomAdapterHolder customAdapterHolder;
    private DBHelperCat dbHelper;
    private SQLiteDatabase database;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_shop);


        // initialization database
        dbHelper = new DBHelperCat(this);
        dbHelper.create_db(); // create database
        database = dbHelper.open(); // open database

        setInformationForList();

        // initialization recycleView
        recyclerView = (RecyclerView) findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        customAdapterHolder = new CustomAdapterHolder(this, categories);
        recyclerView.setAdapter(customAdapterHolder);

        //initialization TextViews and add onClickListener

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


    }
    private void setInformationForList()
    {
        categories.clear();

        try{
            // array CustomAdapters

            //get information from database by condition
            cursor = database.query(DBHelperCat.TABLE_CONTACT,null,null,null,null,null,null);


            if(cursor.moveToFirst()){
                // get index columns
                int nameIndex = cursor.getColumnIndex(DBHelperCat.KEY_NAME);
                int imgIndex = cursor.getColumnIndex(DBHelperCat.KEY_IMG);
                int index = cursor.getColumnIndex(DBHelperCat.KEY_ID);
                do{
                        String nameMenu = cursor.getString(nameIndex);
                        String imgMenu = cursor.getString(imgIndex);
                        String ind = cursor.getString(index);

                        CustomAdapterForCat customAdapter = new CustomAdapterForCat(imgMenu,nameMenu,ind);
                       categories.add(customAdapter);


                }
                while(cursor.moveToNext());
            }
            cursor.close();
        }
        catch (Exception e){Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();}
    }

    public void Send(View v)
    {
        switch (v.getId())
        {
            case R.id.imageView:
              //  startActivity(new Intent(menu_shop.this,podcategories.class).putExtra());
                break;
        }
    }

}

