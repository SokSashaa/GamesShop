package com.example.lavanda;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView maint;
    TextView category;
    TextView about_us;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maint = (TextView)findViewById(R.id.textView);
        category = (TextView) findViewById(R.id.textView3);
        about_us = (TextView) findViewById(R.id.textView5);

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonShowPopupWindowClick(category);
            }
        });
        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,about_us.class));
            }
        });
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
                startActivity(new Intent(MainActivity.this, menu_shop.class).putExtra("menu",0));
            }
        });
        TextView forWedding = (TextView)popupView.findViewById(R.id.textView14);
        forWedding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                startActivity(new Intent(MainActivity.this, menu_shop.class).putExtra("menu",1));
            }
        });
        TextView balls = (TextView)popupView.findViewById(R.id.textView15);
        balls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                startActivity(new Intent(MainActivity.this, menu_shop.class).putExtra("menu",2));
            }
        });
        TextView toys = (TextView)popupView.findViewById(R.id.textView16);
        toys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
                startActivity(new Intent(MainActivity.this, menu_shop.class).putExtra("menu",3));
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