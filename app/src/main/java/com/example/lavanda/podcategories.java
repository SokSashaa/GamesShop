package com.example.lavanda;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class podcategories extends AppCompatActivity {

    private RecyclerView podcat;
    private ArrayList<CustomAdapter> list = new ArrayList<CustomAdapter>();
    private CustomAdapterHolderForProd customAdapterHolder;
    private SQLiteDatabase database;
    private Cursor cursor;
    private DBHelperCat dbHelperCat;
    private String index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.podcategories);

        dbHelperCat = new DBHelperCat(this);
        dbHelperCat.create_db();
        database = dbHelperCat.open();

        index = getIntent().getStringExtra("index");
        setInformationForList();

        podcat = (RecyclerView)findViewById(R.id.ppod);
        podcat.setLayoutManager(new LinearLayoutManager(this));
        customAdapterHolder = new CustomAdapterHolderForProd(this, list);
        podcat.setAdapter(customAdapterHolder);
        podcat.setNestedScrollingEnabled(false);

    }

    private void setInformationForList()
    {
        list.clear();

        try{
            // array CustomAdapters
            CustomAdapter customAdapters;

            String selection = "id_category = ?";

            //get information from database by condition
            cursor = database.query(DBHelper.TABLE_CONTACT,null,selection,new String[] {index},null,null,null);


            if(cursor.moveToFirst()){
                // get index columns
                int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                int priceIndex = cursor.getColumnIndex(DBHelper.KEY_PRICE);
                int imgIndex = cursor.getColumnIndex(DBHelper.KEY_IMG);
                do{
                    String nameMenu = cursor.getString(nameIndex);
                    String priceMenu = cursor.getString(priceIndex);
                    String imgMenu = cursor.getString(imgIndex);

                    CustomAdapter customAdapter = new CustomAdapter(imgMenu,nameMenu,priceMenu);
                    list.add(customAdapter);


                }
                while(cursor.moveToNext());
            }
            cursor.close();
        }
        catch (Exception e){
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();}
    }

}
